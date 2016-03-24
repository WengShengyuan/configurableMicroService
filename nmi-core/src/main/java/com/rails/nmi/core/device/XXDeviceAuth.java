package com.rails.nmi.core.device;

public class XXDeviceAuth implements DeviceAuth {

	@Override
	public boolean deviceAuth() throws Exception {
		System.out.println("authing XX device ... ");
		return false;
	}

}
