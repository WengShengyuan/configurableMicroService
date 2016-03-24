package com.rails.nmi.front.module.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="device")
public class DeviceConfig {
	
	private String mac;
	private String infname;
	private String deviceauth;
	private String commandservice;
	
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getInfname() {
		return infname;
	}
	public void setInfname(String infname) {
		this.infname = infname;
	}
	public String getDeviceauth() {
		return deviceauth;
	}
	public void setDeviceauth(String deviceauth) {
		this.deviceauth = deviceauth;
	}
	public String getCommandservice() {
		return commandservice;
	}
	public void setCommandservice(String commandservice) {
		this.commandservice = commandservice;
	}
}
