package com.rails.nmi.front.module.state;

import com.rails.nmi.core.adapter.CommandService;

public class GlobalCache {

	private volatile static GlobalCache  instance;
	
	private CommandService commandService;
	private boolean deviceAuthState;
	
	public static GlobalCache getInstance(){
		if (instance== null) {
			synchronized(GlobalCache.class){
				if(instance == null){
					instance = new GlobalCache();
				}
			}
        }
		return instance;
	}
	
	private GlobalCache(){}

	public CommandService getCommandService() {
		return commandService;
	}

	public void setCommandService(CommandService commandService) {
		this.commandService = commandService;
	}

	public boolean isDeviceAuthState() {
		return deviceAuthState;
	}

	public void setDeviceAuthState(boolean deviceAuthState) {
		this.deviceAuthState = deviceAuthState;
	}
}
