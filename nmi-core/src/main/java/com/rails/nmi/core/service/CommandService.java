package com.rails.nmi.core.service;

import java.util.List;

import com.rails.nmi.core.wrapper.GPSBean;

public interface CommandService {
	
	public String getCommandServiceType();
	public GPSBean getGPS();
	public List<String> executeFile(String path, String file, String... args) throws Exception;
	public List<String> command(String cmdLine) throws Exception;
}
