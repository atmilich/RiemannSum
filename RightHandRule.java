package Riemann_Sum;

import org.opensourcephysics.display.DrawableShape;
import org.opensourcephysics.frames.*;

import polyfun.Polynomial;

public class RightHandRule extends Riemann{

	/**
	 * Right Hand Rule calculates the area under a curve using a reimann sum with rectangles whose height = the polynomial evaluated at the right point of the base
	 * 
	 * @param poly - the polynomial under which the area is being calculated
	 * @param sleft - the left endpoint
	 * @param sright - the right endpoint
	 * 
	 * @return the area of the rectangle with height poly(sright)
	 */
	@Override
	public double slice(Polynomial poly, double sleft, double sright) {
		return (sright-sleft)*PolyPractice.eval(poly, sright);
	}

	/**
	 * Plots the polynomial & reimann sum using RHR
	 * 
	 * @param pframe - the PlotFrame
	 * @param poly - the polynomial under which the area is being calculated
	 * @param sleft - the left endpoint
	 * @param sright - the right endpoint
	 */
	@Override
	public void slicePlot(PlotFrame pframe, Polynomial poly, double sleft, double sright) {
		double rWidth = sright-sleft;
		double rHeight = PolyPractice.eval(poly, sright);
		double centerX = rWidth/2.0 + sleft;
		double centerY = rHeight/2.0;
		
		DrawableShape sliceRec = DrawableShape.createRectangle(centerX, centerY, rWidth, rHeight);
		pframe.addDrawable(sliceRec);
	}
	
	

}
