package com.rails.nmi.core.oring.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rails.nmi.core.oring.cmd.Command;
import com.rails.nmi.core.oring.cmd.LinuxCommand;
import com.rails.nmi.core.oring.gps.GPSLoader;
import com.rails.nmi.core.service.CommandService;
import com.rails.nmi.core.wrapper.GPSBean;

public class OringCommandService implements CommandService{

	private static final Logger logger = LoggerFactory.getLogger(OringCommandService.class);  
	private Command command = new LinuxCommand();
	
	
	public String getCommandServiceType() {
		return "this is a A command service";
	}

	public GPSBean getGPS() {
		return GPSLoader.getInstance().getBeam();
	}

}
