package Riemann_Sum;

import polyfun.*;
import org.opensourcephysics.frames.*;

import com.sun.prism.BasicStroke;

import java.awt.Color;

import org.opensourcephysics.display.*;

public abstract class Riemann {

	/**
	 * 
	 * @param poly - the polynomial under which the area is calculated
	 * @param left - the left most endpoint of the reimann sum
	 * @param right - the right most endpoint of the reimann sum
	 * @param subintervals - the number of rectangles 
	 * 
	 * @return remsum - sum of the rectangles to approximate the area under the curve
	 * 
	 * calculate a RS given a poly, left & right endpoint, & subintervals
	 */
	public double rs(Polynomial poly, double left, double right, int subintervals){
		double remsum = 0;

		double delta = (right-left)/subintervals;

		for (int i = 0; i < subintervals; i++) {
			remsum += this.slice(poly, left, left+delta);

			left += delta;
		}
		return remsum;	
	}
	
	/**
	 * 
	 * @param pframe - the PlotFrame in which the accumulation function is graphed
	 * @param poly - the Polynomial
	 * @param index - the color
	 * @param precision - the precision over which the rectangles from reimann are plotted
	 * @param lEndpoint - the point at which the accumulation function is plotted
	 * 
	 * @return accumulation function of Polynomial poly
	 * 
	 * Plot the accumulation function
	 */
	public void rsAcc(PlotFrame pframe, Polynomial poly, int index, double precision, double base){

				double x = 10.0;
				Trail accTrail = new Trail(); 
				for (double i = base-x; i <= base+x; i += precision) {
					double reiRecs = this.rs(poly, base, i, 200); 
					pframe.append(index, i, reiRecs); 
					accTrail.addPoint(i, reiRecs); 
				} 
				pframe.addDrawable(accTrail);

				//autoscale
				pframe.setAutoscaleX(true); 
				pframe.setAutoscaleY(true); 
				pframe.setVisible(true);
	}

	/**
	 * 
	 * @param pframe - the PlotFrame in which Riemann sum is graphed
	 * @param p - polynomial used to calculate the height of each rectangle
	 * @param index - set color
	 * @param precision - the minimum distance between x coordinates
	 * @param leftend - the farthest left boundary
	 * @param rightend - the farthest right boundary
	 * @param rects - the number of rectangles (k) used to plot the function
	 * 
	 * plots the Riemann sum
	 */
	public void rsPlot(PlotFrame pframe, Polynomial p, int index, 
		double precision, double leftend, double rightend, int rects) {
		
		double delta = (rightend - leftend)/rects;
		int subintervals = (int) ((rightend-leftend)/delta);

		//plot rectangles
		for (int i = 0; i < subintervals; i++) {
			this.slicePlot(pframe, p, leftend + delta * i, leftend + delta * (i + 1));
		}
		
		//plot poly
		Trail polyTrail = new Trail ();
		
		double yCoord;
		
		for (double i = leftend; i < rightend; i+=precision) {
			yCoord = PolyPractice.eval(p, i);
			polyTrail.addPoint(i, yCoord);
			pframe.append(index, i, yCoord);
		}
		
		pframe.addDrawable(polyTrail);
		
		pframe.setVisible(true); 

	}

	public abstract double slice(Polynomial poly, double sleft, double sright); //declares and sets parameters for slice used in other functions
	
	public abstract void slicePlot(PlotFrame pframe, Polynomial poly, double sleft, double sright); //declares and sets parameters for slicePlot used in other functions
}
