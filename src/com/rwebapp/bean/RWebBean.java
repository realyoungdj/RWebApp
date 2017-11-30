package com.rwebapp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

@ManagedBean(name="rWebBean")
public class RWebBean {
	private RConnection rc;
	
	private double carPrice;
	private List<Double> priceList;
	private String inputPriceString;
	private String inputRString;
	private Boolean renderImageFlag;

	public RWebBean() {
		this.initData();
		this.createRConnection();
	}
	
	private void initData() {
		priceList = new ArrayList<>();
		inputPriceString = "User Input: ";
		inputRString = "";
		renderImageFlag = false;
	}
	
	private void createRConnection() {
		try {
			rc = new RConnection();
		} catch (RserveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String createRS() {
		// This code is used to load r plot image
		try {
			if (!this.inputRString.equals("") && (this.inputRString.length() > 0)) {
				String tmp = "cars <- c(" + this.inputRString + ")";
				rc.eval(tmp);
				rc.eval("png(file = '/Users/jia/Project/temp/temp.png')");
				rc.parseAndEval("plot(cars, type=\"o\", col=\"blue\");dev.off()");
			}
			
		} catch (RserveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (REngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (REXPMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
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
	
	public Boolean getRenderImageFlag() {
		return this.renderImageFlag;
	}
	
	public void setRenderImageFlag(Boolean renderImageFlag) {
		this.renderImageFlag = renderImageFlag;
	}
	
	// Bean Method
	public String addCarPrice() {
		// validate User Input
		
		priceList.add(new Double(this.getCarPrice()));
		this.inputPriceString += this.getCarPrice() + ", ";
		if (this.inputRString.equals(""))
			this.inputRString += this.getCarPrice();
		else
			this.inputRString += "," + this.getCarPrice();
		renderImageFlag = false;
		return null;
	}
	
	public String showRGraphic() {
		this.createRS();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.renderImageFlag = true;
		
		return null;
	}
	
	public String deleteAllData() {
		priceList.clear();
		this.inputPriceString = "User Input: ";
		this.inputRString = "";
		this.renderImageFlag = false;
		return null;
	}
}
