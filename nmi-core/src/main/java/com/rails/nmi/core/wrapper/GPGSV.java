package com.rails.nmi.core.wrapper;

import java.io.Serializable;

/**
 * 可见卫星信息
 * @author WengShengyuan
 *
 */
public class GPGSV implements Serializable{

	private static final long serialVersionUID = 5388595873986839604L;
	
	private String allTele;//GSV语句的总数
	private String currentTele;//本句GSV编号
	private String visualSate;//可视卫星总数00 至 12
	private String[] sateNo;//卫星编号， 01 至 32(可能多个)
	private String[] VAng;//卫星仰角， 00 至 90 度(可能多个)
	private String[] PAng;//卫星方位角， 000 至 359 度(可能多个)
	private String[] CNo;//讯号噪声比(可能多个)
	private String checkSum;//Checksum
	
	public void describe(){
		System.out.println("\n*******可见卫星信息 (GPGSV)*******");
		System.out.println("GSV总数:"+this.allTele);
		System.out.println("本句GSV:"+this.currentTele);
		System.out.println("可视卫星:"+this.visualSate);
		System.out.println("卫星编号:"+this.sateNo);
		System.out.println("卫星仰角:"+this.VAng);
		System.out.println("卫星方位角:"+this.PAng);
		System.out.println("信噪比:"+this.CNo);
	}
	
	public GPGSV(String inStr){
		if(inStr == null || inStr.isEmpty())
			return ;
		
		
		String[] parts = inStr.split(",");
		int partLength = parts.length;
		int setSize = (partLength -4) /4;
		this.allTele = parts[1];
		this.currentTele = parts[2];
		this.visualSate = parts[3];
		this.sateNo = getSet(0,setSize, parts);
		this.VAng = getSet(1,setSize, parts);
		this.PAng = getSet(2,setSize, parts);
		this.CNo = getSet(3,setSize, parts);
		this.checkSum = parts[parts.length-1].split("\\*")[1];
	}
	
	public GPGSV(){}
	
	private String[] getSet(int offSet, int setSize, String[] parts){
		String[] r = new String[setSize];
		
			int index=0;
			for(int i = 4+offSet ; i <4 + (4 * setSize); i = i+4){
				if(index == setSize -1 && offSet == 3){
					r[index] = parts[i].split("\\*")[0];
				} else {
					r[index] = parts[i];
				}
				index ++;
			}
		
		return r;
	}


	public String getAllTele() {
		return allTele;
	}

	public void setAllTele(String allTele) {
		this.allTele = allTele;
	}

	public String getCurrentTele() {
		return currentTele;
	}

	public void setCurrentTele(String currentTele) {
		this.currentTele = currentTele;
	}

	public String getVisualSate() {
		return visualSate;
	}

	public void setVisualSate(String visualSate) {
		this.visualSate = visualSate;
	}

	public String[] getSateNo() {
		return sateNo;
	}

	public void setSateNo(String[] sateNo) {
		this.sateNo = sateNo;
	}

	public String[] getVAng() {
		return VAng;
	}

	public void setVAng(String[] vAng) {
		VAng = vAng;
	}

	public String[] getPAng() {
		return PAng;
	}

	public void setPAng(String[] pAng) {
		PAng = pAng;
	}

	public String[] getCNo() {
		return CNo;
	}

	public void setCNo(String[] cNo) {
		CNo = cNo;
	}

	public String getCheckSum() {
		return checkSum;
	}

	public void setCheckSum(String checkSum) {
		this.checkSum = checkSum;
	}
	
	
}
