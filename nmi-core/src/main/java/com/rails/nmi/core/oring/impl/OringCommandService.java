package com.rails.nmi.core.oring.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rails.nmi.core.oring.cmd.Command;
import com.rails.nmi.core.oring.cmd.LinuxCommand;
import com.rails.nmi.core.oring.cmd.WindowsCommand;
import com.rails.nmi.core.oring.gps.GPSLoader;
import com.rails.nmi.core.service.CommandService;
import com.rails.nmi.core.utils.io.ConfigUtils;
import com.rails.nmi.core.wrapper.GPSBean;

public class OringCommandService implements CommandService{

	private static final Logger logger = LoggerFactory.getLogger(OringCommandService.class);  
	private static Command command;
	private static ConfigUtils config;
	static {
		try {
			config = new ConfigUtils();
			if(config.get("oring.os").toLowerCase().contains("windows")){
				logger.info("当前系统为Windows，载入windows命令行工具");
				command = new WindowsCommand();
			} else {
				logger.info("当前系统为Linux，载入Linux命令行工具");
				command = new LinuxCommand();
			}
		} catch (Exception e) {
			logger.error("载入配置文件失败，无法初始化命令服务。",e);
		}
	}
	
	public String getCommandServiceType() {
		return "this is a A command service";
	}

	public GPSBean getGPS() {
		return GPSLoader.getInstance().getBeam();
	}

	public List<String> executeFile(String path, String file, String... args) throws Exception {
		return command.executeFile(path, file, args);
	}

	public List<String> command(String cmdLine) throws Exception {
		return command.command(cmdLine);
	}

}
