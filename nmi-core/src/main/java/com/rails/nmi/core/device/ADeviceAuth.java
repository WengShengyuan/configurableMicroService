package com.rails.nmi.core.device;

public class ADeviceAuth implements DeviceAuth {

	
	@Override
	public boolean deviceAuth() throws Exception {
		System.out.println("authing A device ... ");
		return true;
	}

}
