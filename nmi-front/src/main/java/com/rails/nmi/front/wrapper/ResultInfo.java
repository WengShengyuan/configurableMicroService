package com.rails.nmi.front.wrapper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResultInfo<T> implements Serializable{

	private static final long serialVersionUID = -1422967031047640749L;
	
	private Map<String, T> map = new HashMap<String, T>();
	private String msg;
	private Integer state = 0;
	
	public void addObj(String key, T obj){
		map.put(key, obj);
	}
	
	public void err(String err){
		this.state = -1;
		this.msg = err;
	}
	
	public void err(Integer state, String err){
		this.state = state;
		err(err);
	}
	
	public Map<String, T> getMap() {
		return map;
	}
	public void setMap(Map<String, T> map) {
		this.map = map;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}
