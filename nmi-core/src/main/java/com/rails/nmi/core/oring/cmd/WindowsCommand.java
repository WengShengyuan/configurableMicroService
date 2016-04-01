package com.rails.nmi.core.oring.cmd;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WindowsCommand implements Command {

	private static final Logger logger = LoggerFactory.getLogger(WindowsCommand.class);

	private static final String div = File.separator;
	private static final String bl = " ";

	public List<String> executeFile(String path, String file, String... args) throws Exception {

		List<String> returns = new ArrayList<String>();
		StringBuilder commandBuilder = new StringBuilder();
		commandBuilder.append(path).append(div).append(file);
		if (args != null) {
			for (String arg : args) {
				commandBuilder.append(bl).append(arg);
			}
		}
		logger.info("执行Shell指令  : " + commandBuilder.toString());
		String line;

		// Get input streams
		BufferedReader stdInput = null;
		BufferedReader stdError = null;

		try {
			// Run "netsh" Windows command
			Process process = Runtime.getRuntime().exec(commandBuilder.toString());

			// Get input streams
			stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
			stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

			// Read command standard output
			while ((line = stdInput.readLine()) != null) {
				returns.add(line);
			}

			// Read command errors
			while ((line = stdError.readLine()) != null) {
				returns.add(line);
			}
			process.waitFor();
			System.out.println("执行指令结束返回: " + process.exitValue());
			process.destroy();

		} catch (Exception e) {
			logger.error("指令执行错误:" + e);
			throw e;
		} finally {
			if (stdInput != null) {
				stdInput.close();
			}
			if (stdError != null) {
				stdError.close();
			}
		}
		return returns;
	}

	public List<String> command(String cmdLine) throws Exception {
		logger.info("执行Shell指令  : " + cmdLine);
		String line;
		// Get input streams
		BufferedReader stdInput = null;
		BufferedReader stdError = null;
		List<String> returns = new ArrayList<String>();
		try {
			Process process = Runtime.getRuntime().exec(cmdLine);
			// Get input streams
			stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
			stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

			// Read command standard output
			while ((line = stdInput.readLine()) != null) {
				returns.add(line);
			}

			// Read command errors
			while ((line = stdError.readLine()) != null) {
				returns.add(line);
			}
			process.waitFor();
			System.out.println("执行指令结束返回: " + process.exitValue());
			process.destroy();
		} catch (Exception e) {
			logger.error("指令执行错误:" + e);
			throw e;
		} finally {
			if (stdInput != null) {
				stdInput.close();
			}
			if (stdError != null) {
				stdError.close();
			}
		}
		return returns;
	}

}
