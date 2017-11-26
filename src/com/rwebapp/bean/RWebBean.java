package com.rwebapp.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="RWebBean")

public class RWebBean {
	
	private double carPrice;

	public RWebBean() {
		this.createRConnection();
	}
	
	private void createRConnection() {
		
	}
	
	public double getCarPrice() {
		return this.carPrice;
	}
	
	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}
	
	public String addCarPrice() {
		return null;
	}
	
	public String showRGraphic() {
		return null;
	}
	
	public String deleteAllData() {
		return null;
	}
}
