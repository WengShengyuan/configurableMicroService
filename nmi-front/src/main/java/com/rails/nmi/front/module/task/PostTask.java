package com.rails.nmi.front.module.task;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(PostTask.class);

	@Autowired
	DeviceConfig config;

	@PostConstruct
	public void init() {
		logger.info("初始化完成，开始载入模块");
		
		String deviceAuthClass = config.getDeviceauth();
		String commandService = config.getCommandservice();
		logger.info("读取设备:" + deviceAuthClass);
		logger.info("读取服务:" + commandService);

		try {
			logger.info("载入设备:" + deviceAuthClass);
			auth = DeviceAuthFactory.getInstance().build(deviceAuthClass).getAuth();
			logger.info("验证设备...");
			GlobalCache.getInstance().setDeviceAuthState(auth.deviceAuth());
			if (GlobalCache.getInstance().isDeviceAuthState()) {
				logger.info("设备验证通过!，载入服务:" + commandService);
				GlobalCache.getInstance().setCommandService(
						CommandServiceFactory.getInstance().build(commandService).getCommandService());
			} else {
				GlobalCache.getInstance().setDeviceAuthState(false);
				logger.info("设备验证未通过，禁用外部接口!");
			}

		} catch (Exception e) {
			logger.error("模块载入失败，禁用外部接口!" + e);
			GlobalCache.getInstance().setDeviceAuthState(false);
		}
	}

}
