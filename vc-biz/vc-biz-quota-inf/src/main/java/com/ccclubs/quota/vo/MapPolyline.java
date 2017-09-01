package com.ccclubs.quota.vo;

import java.io.Serializable;

public class MapPolyline implements Serializable { 
	/**
	 * 
	 */
	private static final long serialVersionUID = -6365906911080673186L;
	private double x;
	private double y;
	public MapPolyline(){
		
	}
	public MapPolyline(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
}
