package com.rwebapp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="RWebBean")

public class RWebBean {
	
	private double carPrice;
	private List<Double> priceList;
	private String inputPriceString;

	public RWebBean() {
		this.initData();
		this.createRConnection();
	}
	
	private void initData() {
		priceList = new ArrayList<>();
		inputPriceString = "User Input: ";
	}
	
	private void createRConnection() {
		
	}
	
	// getter and setter
	public double getCarPrice() {
		return this.carPrice;
	}
	
	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}
	
	public List<Double> getPriceList() {
		return this.priceList;
	}
	
	public void setPriceList(List<Double> priceList) {
		this.priceList = priceList;
	}
	
	public String getInputPriceString() {
		return inputPriceString;
	}
	
	public void setInputPriceString(String inputPriceString) {
		this.inputPriceString = inputPriceString;
	}
	
	// Bean Method
	public String addCarPrice() {
		// check User Input
		
		priceList.add(new Double(this.getCarPrice()));
		this.inputPriceString += this.getCarPrice() + " ";
		return null;
	}
	
	public String showRGraphic() {
		return null;
	}
	
	public String deleteAllData() {
		priceList.clear();
		this.inputPriceString = "User Input: ";
		return null;
	}
}
