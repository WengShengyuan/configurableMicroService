package com.rails.nmi.front.module.task;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rails.nmi.core.device.DeviceAuth;
import com.rails.nmi.front.module.config.DeviceConfig;
import com.rails.nmi.front.module.factory.CommandServiceFactory;
import com.rails.nmi.front.module.factory.DeviceAuthFactory;
import com.rails.nmi.front.module.state.GlobalCache;

@Component
public class PostTask {

	DeviceAuth auth = null;

	@Autowired
	DeviceConfig config;

	@PostConstruct
	public void init() {
		System.out.println("init finished");
		try {
			System.out.println("********  reading config  ********");
			System.out.println("mac in config : " + config.getMac());
			System.out.println("interface name : " + config.getInfname());
			System.out.println("device auth impl name : " + config.getDeviceauth());
			System.out.println("device command service impl name : " + config.getCommandservice());
			String deviceAuthClass = config.getDeviceauth();
			String commandService = config.getCommandservice();

			System.out.println("\n********  registering module  ********");
			
			System.out.println("loading auth class ...");

			try {
				auth = DeviceAuthFactory.getInstance().build(deviceAuthClass).getAuth();
				GlobalCache.getInstance().setDeviceAuthState(auth.deviceAuth());
				
				if (GlobalCache.getInstance().isDeviceAuthState()) {
					System.out.println("device auth success!");
					System.out.println("loading command service ...");
					GlobalCache.getInstance().setCommandService(
							CommandServiceFactory.getInstance().build(commandService).getCommandService());
				} else {
					GlobalCache.getInstance().setDeviceAuthState(false);
					System.out.println("device auth fail!");
				}

			} catch (Exception e) {
				System.out.println("init fail, error:"+e);
				GlobalCache.getInstance().setDeviceAuthState(false);
			}

		} catch (Exception e) {
			System.out.println("auth err");
		}
	}

}
