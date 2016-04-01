package com.rails.nmi.core.wrapper;

import java.io.Serializable;

/**
 * GPS定位信息
 * @author WengShengyuan
 *
 */
public class GPGGA implements Serializable{

	private static final long serialVersionUID = 3396845589188241202L;
	
	private String UTC;//UTC 时间，格式为hhmmss.sss
	private String latitude;//纬度，格式为ddmm.mmmm(第一位是零也将传送)
	private String latitude_G;//纬度半球，N 或S(北纬或南纬)
	private String longitude;//经度，格式为dddmm.mmmm(第一位零也将传送)；
	private String longitude_G;//经度半球，E 或W(东经或西经)
	private String valid;//定位质量指示，0=定位无效，1=定位有效；
	private String sateNo;//使用卫星数量，从00到12(第一个零也将传送)
	private String HDOP;//水平精确度，0.5到99.9
	private String seaLevel;//天线离海平面的高度，-9999.9到9999.9米M指单位米
	private String groundLevel;//大地水准面高度，-9999.9到9999.9米M指单位米
	private String RTCM;//差分GPS数据期限(RTCMSC-104)，最后设立RTCM传送的秒数量
	private String station;//差分参考基站标号
	
	public void describe(){
		System.out.println("\n*******定位信息(GPGGA)*******");
		System.out.println("UTC:"+this.UTC);
		System.out.println("经度:"+this.latitude);
		System.out.println("经度半球："+this.latitude_G);
		System.out.println("纬度:"+this.longitude);
		System.out.println("纬度半球："+this.longitude_G);
		System.out.println("卫星编号:"+this.sateNo);
		System.out.println("海平面高度:"+this.seaLevel);
		System.out.println("大地水准高度:"+this.groundLevel);
		System.out.println("定位质量:"+this.valid);
		
	}
	
	public GPGGA(String inStr){
		if(inStr == null || inStr.isEmpty())
			return;
		
		String[] parts = inStr.split(",");
		this.UTC = parts[1];
		this.latitude = parts[2];
		this.latitude_G = parts[3];
		this.longitude = parts[4];
		this.longitude_G = parts[5];
		this.valid = parts[6];
		this.sateNo = parts[7];
		this.HDOP = parts[8];
		this.seaLevel = parts[9];
		//M忽略
		this.groundLevel = parts[11];
		
	}
	
	public GPGGA(){}
	
	public String getUTC() {
		return UTC;
	}
	public void setUTC(String uTC) {
		UTC = uTC;
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

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getSateNo() {
		return sateNo;
	}

	public void setSateNo(String sateNo) {
		this.sateNo = sateNo;
	}

	public String getHDOP() {
		return HDOP;
	}

	public void setHDOP(String hDOP) {
		HDOP = hDOP;
	}

	public String getSeaLevel() {
		return seaLevel;
	}
	public void setSeaLevel(String seaLevel) {
		this.seaLevel = seaLevel;
	}
	public String getGroundLevel() {
		return groundLevel;
	}
	public void setGroundLevel(String groundLevel) {
		this.groundLevel = groundLevel;
	}
	public String getRTCM() {
		return RTCM;
	}
	public void setRTCM(String rTCM) {
		RTCM = rTCM;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
}
