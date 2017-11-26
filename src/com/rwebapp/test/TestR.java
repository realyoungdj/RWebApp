package com.rwebapp.test;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class TestR {
	public static void main(String[] args) throws RserveException, REXPMismatchException {
		// Before run this program, 
		// Start Rserve in RStudio.
		// Rserve(args)
		// to shutdown, in command line 
		// killall Rserve
		RConnection c = new RConnection();
		REXP x = c.eval("seq(-5, 5, by=.5)");
		if (x.isVector())
		{
			System.out.println("vector");
			double tmp[] = x.asDoubles();
			for (int i = 0; i < tmp.length; i++)
			System.out.println(tmp[i]);
		}
	}
}
