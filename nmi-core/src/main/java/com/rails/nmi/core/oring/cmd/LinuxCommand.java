package com.rails.nmi.core.oring.cmd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinuxCommand implements Command {

	private static final Logger logger = LoggerFactory.getLogger(LinuxCommand.class);

	private static final String div = File.separator;
	private static final String bl = " ";

	public List<String> executeFile(String path, String file, String... args) throws Exception {
		List<String> returns = new ArrayList<String>();
		StringBuilder commandBuilder = new StringBuilder();
		commandBuilder.append(path).append(div).append(file);
		if (null != args) {
			for (String arg : args) {
				commandBuilder.append(bl).append(arg);
			} 
		}
		logger.info("执行Shell指令  : " + commandBuilder.toString());
		String line;
		BufferedReader br = null;
		try {
			Process p = Runtime.getRuntime().exec(commandBuilder.toString());
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = br.readLine()) != null) {
				returns.add(line);
			}
			p.waitFor();
			System.out.println("执行指令结束返回: " + p.exitValue());
			p.destroy();
		} catch (SecurityException e) {
			logger.error("执行指令错误", e);
			throw new Exception("系统安全错误:" + e);
		} catch (IOException e) {
			logger.error("执行指令错误", e);
			throw new Exception("IO错误:" + e);
		} catch (NullPointerException e) {
			logger.error("执行指令错误", e);
			throw new Exception("空指针错误:" + e);
		} catch (IllegalArgumentException e) {
			logger.error("执行指令错误", e);
			throw new Exception("非法参数错误:" + e);
		} finally {
			if(br != null){
				br.close();
			}
		}
		return returns;
	}

	public List<String> command(String cmdLine) throws Exception {
		List<String> returns = new ArrayList<String>();
		logger.info("执行Shell指令  : " + cmdLine);
		String line;
		BufferedReader br = null;
		try {
			Process p = Runtime.getRuntime().exec(cmdLine);
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = br.readLine()) != null) {
				returns.add(line);
			}
			p.waitFor();
			System.out.println("执行指令结束返回: " + p.exitValue());
			p.destroy();
		} catch (SecurityException e) {
			logger.error("执行指令错误", e);
			throw new Exception("系统安全错误:" + e);
		} catch (IOException e) {
			logger.error("执行指令错误", e);
			throw new Exception("IO错误:" + e);
		} catch (NullPointerException e) {
			logger.error("执行指令错误", e);
			throw new Exception("空指针错误:" + e);
		} catch (IllegalArgumentException e) {
			logger.error("执行指令错误", e);
			throw new Exception("非法参数错误:" + e);
		} finally {
			if(br != null){
				br.close();
			}
		}
		return returns;
	}


}
