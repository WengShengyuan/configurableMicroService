package com.rails.nmi.front.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rails.nmi.front.module.factory.CommandServiceFactory;
import com.rails.nmi.front.module.state.GlobalCache;

@Controller
public class RequestController {

	
	@ResponseBody
	@RequestMapping(name ="getCommandServiceType")
	public String getCommandServiceType(){
		if(GlobalCache.getInstance().isDeviceAuthState()){
			return CommandServiceFactory.getInstance().getCommandService().getCommandServiceType();
		} else {
			return "Auth fail! you can not access to this data";
		}
	}
	
}
