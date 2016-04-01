package com.rails.nmi.core.oring.gps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.rails.nmi.core.wrapper.GPSBean;

public class GPSLoader {
	private volatile static GPSLoader instance;
	private static String filePath = "";
	public static GPSLoader getInstance(){
		if(instance == null){
			synchronized(GPSLoader.class){
				if(instance == null){
					instance = new GPSLoader();
				}
			}
		}
		return instance;
	}
	
	private GPSLoader(){
		filePath = "C://gps.txt";
	}
	
	public GPSBean getBeam(){
		List<String> strs = readFile();
		if(strs == null){
			return null;
		}
		return new GPSBean(strs);
	}
	
	private List<String> readFile(){
		InputStreamReader ir =null;
		BufferedReader br = null;
		try {
			File f = new File(this.filePath);
			if(f.exists()){
				ir = new InputStreamReader(new FileInputStream(f),"UTF-8");
				br = new BufferedReader(ir);
				List<String> r = new ArrayList<String>();
				String line = null;
				while((line = br.readLine())!=null){
					r.add(line);
				}
				return r;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(br != null){
					br.close();
				}
				if(ir != null){
					ir.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
