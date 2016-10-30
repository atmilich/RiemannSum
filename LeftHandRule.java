package Riemann_Sum;

import polyfun.Polynomial;

import org.opensourcephysics.display.DrawableShape;
import org.opensourcephysics.frames.*;

public class LeftHandRule extends Riemann {

	/**
	 * Left hand rule: calculate the area under a curve using rectangles with heights equal to the left-side point
	 * 
	 * @param poly - the polynomial being used
	 * @param sleft - the left most endpoint (also the height of the rectangle when poly is evaluated at sleft)
	 * @param sright - the right most endpoint, creates interval inside which the area is calculated
	 * 
	 * @return the area of each rectangle with height poly(sleft)
	 */
	
	@Override
	public double slice(Polynomial poly, double sleft, double sright) {
		return (sright - sleft) * PolyPractice.eval(poly, sleft);

	}

	/**
	 * Plots the graph of the polynomial and the LHR rectangles
	 * 
	 * @param pframe - PlotFrame in which graph is graphed
	 * @param poly - the polynomial being used
	 * @param sleft - the left endpoint of the interval
	 * @param sright - the right endpoint of the interval
	 */
	
	@Override
	public void slicePlot(PlotFrame pframe, Polynomial poly, double sleft, double sright) {
		double rWidth = sright-sleft;
		double rHeight = PolyPractice.eval(poly, sleft);
		double centerX = rWidth/2.0 + sleft;
		double centerY = rHeight/2.0;
		
		DrawableShape sliceRec = DrawableShape.createRectangle(centerX, centerY, rWidth, rHeight);
		pframe.addDrawable(sliceRec);
	}
	
}
