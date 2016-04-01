package com.rails.nmi.front.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rails.nmi.core.wrapper.GPSBean;
import com.rails.nmi.front.module.factory.CommandServiceFactory;
import com.rails.nmi.front.module.state.GlobalCache;
import com.rails.nmi.front.wrapper.ResultInfo;

@RestController
@RequestMapping(value = "/api")
public class RequestController {

	private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

	@ResponseBody
	@RequestMapping(value = "getCommandServiceType")
	public ResultInfo<String> getCommandServiceType() {
		ResultInfo<String> result = new ResultInfo<String>();
		if (GlobalCache.getInstance().isDeviceAuthState()) {
			String serviceType = CommandServiceFactory.getInstance().getCommandService().getCommandServiceType();
			result.addObj("service", serviceType);
		} else {
			logger.info("请求被阻止");
			result.err("Auth fail");
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "getGPS")
	public ResultInfo<GPSBean> getGPS() {
		ResultInfo<GPSBean> result = new ResultInfo<GPSBean>();
		if (GlobalCache.getInstance().isDeviceAuthState()) {
			GPSBean bean = CommandServiceFactory.getInstance().getCommandService().getGPS();
			result.addObj("bean", bean);
		} else {
			logger.info("请求被阻止");
			result.err("Auth fail");
		}
		return result;
	}

}
