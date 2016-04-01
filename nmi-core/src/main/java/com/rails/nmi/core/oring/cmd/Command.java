package com.rails.nmi.core.oring.cmd;

import java.util.List;

public interface Command {
	
	public List<String> executeFile(String path, String file, String... args) throws Exception;
	public List<String> command(String cmdLine) throws Exception;
}
