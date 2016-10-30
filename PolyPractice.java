package Riemann_Sum;
import org.opensourcephysics.display.DrawingFrame;
import org.opensourcephysics.frames.PlotFrame;

import polyfun.*;

public class PolyPractice {
	
	/**
	 * Evaluates a function at a number and returns the double
	 * @param p - the polynomial used
	 * @param x - the double at which p is evaluated
	 * @return the polynomial p at x returned as a double
	 */
	public static double eval(Polynomial p, double x){
		return p.evaluate(x).getTerms()[0].getTermDouble();	
	}
	
	/**
	 * Adds and graphs a polynomial plus x^2
	 * @param p - the polynomial used
	 * 
	 */
	public void addXsquared(Polynomial p){
		Polynomial add = new Polynomial(new double[] {0, 0, 1});
		
		p = p.plus(add);
		p.print();
		
		PlotFrame graph_frame = new PlotFrame("x", "y", "addXsquared Graph");
		int max = 15; 
		int min = -15;
		int dataSet = 0;

		graph_frame.setPreferredMinMax(min, max, min, max);
		for (double i = min; i<max-min; i+=.01) {
			graph_frame.append(dataSet, i, eval(p, i)); 
		}
		graph_frame.setVisible(true);
	}

}