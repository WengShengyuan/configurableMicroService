package com.rails.nmi.front.module.factory;

import com.rails.nmi.core.device.DeviceAuth;

public class DeviceAuthFactory {
	private volatile static DeviceAuthFactory  instance;
	
	private String className="";
	private DeviceAuth auth;

	public static DeviceAuthFactory getInstance(){
		if (instance== null) {
			synchronized(DeviceAuthFactory.class){
				if(instance == null){
					instance = new DeviceAuthFactory();
				}
			}
        }
		return instance;
	}
	
	private DeviceAuthFactory(){ }

	public DeviceAuthFactory build(String className) throws Exception{
		this.className = className;
		auth = (DeviceAuth) Class.forName(className).newInstance();
		return this;
	}
	
	public DeviceAuth getAuth() {
		return auth;
	}
	
	public String getClassName(){
		return className;
	}
	
}
