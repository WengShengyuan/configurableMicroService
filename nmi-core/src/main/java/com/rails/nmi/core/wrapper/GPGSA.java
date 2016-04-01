package com.rails.nmi.core.wrapper;

import java.io.Serializable;

/**
 * 当前卫星信息
 * @author WengShengyuan
 *
 */
public class GPGSA implements Serializable{
	private static final long serialVersionUID = -1785765951185761203L;
	
	private String mode;//模式：M手动；A自动
	private String locateType;//定位模式：1未定位；2二维定位；3三维定位
	private String[] PRN; //01 至 32 表天空使用中的卫星编号，最多可接收12颗卫星信息
	private String PDOP;//PDOP位置精度因子（0.5~99.9）
	private String HDOP;//HDOP水平精度因子（0.5~99.9）
	private String VDOP;//VDOP垂直精度因子（0.5~99.9）
	private String checkSum;//检查位
	
	public void describe(){
		System.out.println("\n*******当前卫星信息 (GPGSA)*******");
		System.out.println("模式:"+this.mode);
		System.out.println("定位模式:"+this.locateType);
		System.out.println("PRN:"+this.PRN);
	}
	public GPGSA(String inStr){
		if(inStr == null || inStr.isEmpty())
			return;
		
		String[] parts = inStr.split(",");
		this.mode = parts[1];
		this.locateType = parts[2];
		PRN = new String[12];
		for(int i = 3 ; i < 15;i ++){
			if(!parts[i].isEmpty()){
				PRN[i-3]=parts[i];
			}else {
				PRN[i-3]="";
			}
		}
		this.PDOP = parts[15];
		this.HDOP = parts[16];
		this.VDOP = parts[17].split("\\*")[0];
		this.checkSum = parts[17].split("\\*")[1];
	}
	
	public GPGSA(){}
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getLocateType() {
		return locateType;
	}
	public void setLocateType(String locateType) {
		this.locateType = locateType;
	}
	
	public String[] getPRN() {
		return PRN;
	}

	public void setPRN(String[] pRN) {
		PRN = pRN;
	}

	public String getPDOP() {
		return PDOP;
	}

	public void setPDOP(String pDOP) {
		PDOP = pDOP;
	}

	public String getHDOP() {
		return HDOP;
	}

	public void setHDOP(String hDOP) {
		HDOP = hDOP;
	}

	public String getVDOP() {
		return VDOP;
	}

	public void setVDOP(String vDOP) {
		VDOP = vDOP;
	}

	public String getCheckSum() {
		return checkSum;
	}
	public void setCheckSum(String checkSum) {
		this.checkSum = checkSum;
	}
	
}
