package com.rails.nmi.core.oring.cmd;

import java.util.List;

public interface Command {
	
	public List<String> pushCommand(String path, String file, String... args) throws Exception;;

}
