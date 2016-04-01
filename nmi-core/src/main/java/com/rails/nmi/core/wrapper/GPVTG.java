package com.rails.nmi.core.wrapper;

import java.io.Serializable;
/**
 * 地面速度信息
 * @author WengShengyuan
 *
 */
public class GPVTG implements Serializable{

	private static final long serialVersionUID = 3281814699149356318L;
	
	private String realCourse="";// 以真北为参考基准的地面航向（000~359度，前面的0也将被传输）
	private String magCourse="";// 以磁北为参考基准的地面航向（000~359度，前面的0也将被传输）
	private String speed_knots="";// 地面速率（000.0~999.9节，前面的0也将被传输）
	private String speed_km="";// 地面速率（0000.0~1851.8公里/小时，前面的0也将被传输）
	private String mode="";// 模式指示（仅NMEA0183 3.00版本输出，A=自主定位，D=差分，E=估算，N=数据无效）
	
	public void describe(){
		System.out.println("\n*******地面速度信息(GPVTG)*******");
		System.out.println("真北航向:"+this.realCourse);
		System.out.println("磁北航向:"+this.magCourse);
		System.out.println("地面速率(节):"+this.speed_knots);
		System.out.println("地面速率(km):"+this.speed_km);
	}
	
	public GPVTG(String inStr){
		if(inStr == null || inStr.isEmpty())
			return;
		String[] parts = inStr.split(",");
		this.realCourse = parts[1];
		this.magCourse = parts[3];
		this.speed_knots = parts[5];
		this.speed_km = parts[7];
		this.mode = parts[9];
	}
	
	public GPVTG(){}
	public String getRealCourse() {
		return realCourse;
	}
	public void setRealCourse(String realCourse) {
		this.realCourse = realCourse;
	}
	public String getMagCourse() {
		return magCourse;
	}
	public void setMagCourse(String magCourse) {
		this.magCourse = magCourse;
	}
	public String getSpeed_knots() {
		return speed_knots;
	}
	public void setSpeed_knots(String speed_knots) {
		this.speed_knots = speed_knots;
	}
	public String getSpeed_km() {
		return speed_km;
	}
	public void setSpeed_km(String speed_km) {
		this.speed_km = speed_km;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}

	
}
