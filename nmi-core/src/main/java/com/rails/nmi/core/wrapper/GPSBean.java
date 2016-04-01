package com.rails.nmi.core.wrapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * GPS数据
 * @author WengShengyuan
 *
 */
public class GPSBean implements Serializable{
	
	private static final long serialVersionUID = -7137277754871718617L;

	private GPGGA gpgga;
	private GPGSA gpgsa;
	private List<GPGSV> gpgsv;
	private GPRMC gprmc;
	private GPVTG gpvtg;
	
	public void describe(){
		System.out.println("GPS信息：");
		this.gpgga.describe();
		this.gpgsa.describe();
		for(GPGSV g : gpgsv){
			g.describe();
		}
		gprmc.describe();
		gpvtg.describe();
	}
	
	public GPSBean(List<String> strs){
		for(String str : strs){
			if(str.contains("GPGGA")){
				this.gpgga = new GPGGA(str);
			}
			if(str.contains("GPGSA")){
				this.gpgsa = new GPGSA(str);
			}
			if(str.contains("GPGSV")){
				if(gpgsv == null){
					this.gpgsv = new ArrayList<GPGSV>();
					this.gpgsv.add(new GPGSV(str));
				} else {
					gpgsv.add(new GPGSV(str));
				}
			}
			if(str.contains("GPRMC")){
				this.gprmc = new GPRMC(str);
			}
			if(str.contains("GPVTG")){
				this.gpvtg = new GPVTG(str);
			}
		}
	}

	public GPGGA getGpgga() {
		return gpgga;
	}

	public void setGpgga(GPGGA gpgga) {
		this.gpgga = gpgga;
	}

	public GPGSA getGpgsa() {
		return gpgsa;
	}

	public void setGpgsa(GPGSA gpgsa) {
		this.gpgsa = gpgsa;
	}

	public List<GPGSV> getGpgsv() {
		return gpgsv;
	}

	public void setGpgsv(List<GPGSV> gpgsv) {
		this.gpgsv = gpgsv;
	}

	public GPRMC getGprmc() {
		return gprmc;
	}

	public void setGprmc(GPRMC gprmc) {
		this.gprmc = gprmc;
	}

	public GPVTG getGpvtg() {
		return gpvtg;
	}

	public void setGpvtg(GPVTG gpvtg) {
		this.gpvtg = gpvtg;
	}
}
