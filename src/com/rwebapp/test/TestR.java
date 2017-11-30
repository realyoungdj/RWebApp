package com.rwebapp.test;

import java.io.IOException;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class TestR {
	public static void main(String[] args) throws REXPMismatchException, REngineException, IOException {
		// Before run this program, 
		// Start Rserve in RStudio.
		// Rserve(args)
		// to shutdown, in command line 
		// killall Rserve
		RConnection rc = new RConnection();
		/*
		REXP x = rc.eval("seq(-5, 5, by=.5)");
		if (x.isVector())
		{
			System.out.println("vector");
			double tmp[] = x.asDoubles();
			for (int i = 0; i < tmp.length; i++)
			System.out.println(tmp[i]);
		}
		*/
		// Test to save image
/*		rc.eval("cars <- c(4,1,9,3,10,4.5,8.7,200)");
		rc.eval("png(file = '/Users/jia/Project/workspace/RWebApp/WebContent/temp.png')");
		rc.parseAndEval("plot(cars, type=\"o\", col=\"blue\");dev.off()");*/
		


	}
}
