package com.rails.nmi.core.oring.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rails.nmi.core.device.DeviceAuth;

public class OringDeviceAuth implements DeviceAuth {

	private static final Logger logger = LoggerFactory.getLogger(OringDeviceAuth.class);
	
	public boolean deviceAuth() throws Exception {
		logger.info("Oring 验证设备中...");
		return true;
	}

}
