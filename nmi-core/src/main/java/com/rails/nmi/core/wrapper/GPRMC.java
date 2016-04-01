package com.rails.nmi.core.wrapper;

import java.io.Serializable;

/**
 * 推荐定位信息
 * @author WengShengyuan
 *
 */
public class GPRMC implements Serializable{

	private static final long serialVersionUID = 1589911491297356396L;
	
	private String UTC_T;//UTC时间，hhmmss（时分秒）格式 
	private String locateState;//定位状态，A=有效定位，V=无效定位 
	private String latitude;//纬度ddmm.mmmm（度分）格式（前面的0也将被传输） 
	private String latitude_G;//纬度半球N（北半球）或S（南半球） 
	private String longitude;//经度dddmm.mmmm（度分）格式（前面的0也将被传输） 
	private String longitude_G;//经度半球E（东经）或W（西经） 
	private String speed;//地面速率（000.0~999.9节，前面的0也将被传输） 
	private String course;//地面航向（000.0~359.9度，以真北为参考基准，前面的0也将被传输） 
	private String UTC_D;//UTC日期，ddmmyy（日月年）格式 
	private String declination;//磁偏角（000.0~180.0度，前面的0也将被传输）
	private String declination_G;//磁偏角方向，E（东）或W（西） 
	private String mode;//模式指示（仅NMEA0183 3.00版本输出，A=自主定位，D=差分，E=估算，N=数据无效）
	
	public void describe(){
		System.out.println("\n*******推荐定位信息(GPRMC)*******");
		System.out.println("UTC_TIME:"+this.UTC_T);
		System.out.println("经度:"+this.latitude);
		System.out.println("经度半球:"+this.latitude_G);
		System.out.println("纬度:"+this.longitude);
		System.out.println("纬度半球:"+this.longitude_G);
		System.out.println("地面速率:"+this.speed);
		System.out.println("地面航向:"+this.course);
		System.out.println("模式:"+this.mode);
		
	}
	
	public GPRMC(String inStr){
		if(inStr == null || inStr.isEmpty())
			return ;
		String[] parts = inStr.split(",");
		this.UTC_T = parts[1];
		this.locateState = parts[2];
		this.latitude = parts[3];
		this.latitude_G = parts[4];
		this.longitude = parts[5];
		this.longitude_G = parts[6];
		this.speed = parts[7];
		this.course = parts[8];
		this.UTC_D = parts[9];
		this.declination = parts[10];
		this.declination_G = parts[11];
		this.mode = parts[12].split("\\*")[0];
	}
	public GPRMC(){}
	
	public String getUTC_T() {
		return UTC_T;
	}
	public void setUTC_T(String uTC_T) {
		UTC_T = uTC_T;
	}
	public String getLocateState() {
		return locateState;
	}
	public void setLocateState(String locateState) {
		this.locateState = locateState;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLatitude_G() {
		return latitude_G;
	}
	public void setLatitude_G(String latitude_G) {
		this.latitude_G = latitude_G;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLongitude_G() {
		return longitude_G;
	}
	public void setLongitude_G(String longitude_G) {
		this.longitude_G = longitude_G;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getUTC_D() {
		return UTC_D;
	}
	public void setUTC_D(String uTC_D) {
		UTC_D = uTC_D;
	}
	public String getDeclination() {
		return declination;
	}
	public void setDeclination(String declination) {
		this.declination = declination;
	}
	public String getDeclination_G() {
		return declination_G;
	}
	public void setDeclination_G(String declination_G) {
		this.declination_G = declination_G;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
}
