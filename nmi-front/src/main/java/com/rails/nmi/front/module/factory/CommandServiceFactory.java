package com.rails.nmi.front.module.factory;

import com.rails.nmi.core.service.CommandService;

public class CommandServiceFactory {
	private volatile static CommandServiceFactory  instance;
	
	private String className;
	private CommandService service;
	
	public static CommandServiceFactory getInstance(){
		if (instance== null) {
			synchronized(CommandServiceFactory.class){
				if(instance == null){
					instance = new CommandServiceFactory();
				}
			}
        }
		return instance;
	}
	
	private CommandServiceFactory(){ }
	
	public CommandServiceFactory build(String className) throws Exception{
		this.className = className;
		service = (CommandService) Class.forName(className).newInstance();
		return this;
	}
	
	public CommandService getCommandService() {
		return service;
	}
	
	public String getClassName(){
		return className;
	}
	
}
