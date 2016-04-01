package com.rails.nmi.front.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	@ResponseBody
	@RequestMapping(value = "testCommand")
	public ResultInfo<List<String>> testCommand(HttpServletRequest request, HttpServletResponse response){
		ResultInfo<List<String>> result = new ResultInfo<List<String>>();
		if (GlobalCache.getInstance().isDeviceAuthState()) {
			try {
				String cmd = request.getParameter("cmd");
				List<String> results = CommandServiceFactory.getInstance().getCommandService().command(cmd);
				result.addObj("result", results);
			} catch (Exception e) {
				logger.error("调用服务错误",e);
				result.err("调用服务错误,"+e);
				return result;
			}
		} else {
			logger.info("请求被阻止");
			result.err("Auth fail");
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "testExec")
	public ResultInfo<List<String>> testExec(HttpServletRequest request, HttpServletResponse response){
		ResultInfo<List<String>> result = new ResultInfo<List<String>>();
		if (GlobalCache.getInstance().isDeviceAuthState()) {
			try {
				String path = request.getParameter("cmd");
				String file = request.getParameter("file");
				String args = request.getParameter("args");
				List<String> results = CommandServiceFactory.getInstance().getCommandService().executeFile(path, file, args);
				result.addObj("result", results);
			} catch (Exception e) {
				logger.error("调用服务错误",e);
				result.err("调用服务错误,"+e);
				return result;
			}
		} else {
			logger.info("请求被阻止");
			result.err("Auth fail");
		}
		return result;
	}

}
