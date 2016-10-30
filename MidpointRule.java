package Riemann_Sum;

import org.opensourcephysics.display.DrawableShape;
import org.opensourcephysics.frames.PlotFrame;

import polyfun.Polynomial;

public class MidpointRule extends Riemann {

	/**
	 * Calculates the area of a rectangle whose height is the poly evaluated at the midpoint of the base
	 * 
	 * @param poly - the polynomial under which the area is being calculated
	 * @param sleft - the left endpoint of the interval
	 * @param sright - the right endpoint of the interval
	 * 
	 * @return returns the area of the rectangle with height in the middle of the base
	 */
	@Override
	public double slice(Polynomial poly, double sleft, double sright) {
		return (sright-sleft)*PolyPractice.eval(poly, (sright+sleft)/2.0);
	}

	/**
	 * Plots the Reimann sum with rectangles whose height is in the middle of the base
	 * 
	 * @param pframe - the PlotFrame
	 * @param poly - the polynomial under which the area is being calculated
	 * @param sleft - the left endpoint of the interval
	 * @param sright - the right endpoint of the interval
	 */
	@Override
	public void slicePlot(PlotFrame pframe, Polynomial poly, double sleft, double sright) {
		double centerX = (sright+sleft)/2.0; //average of left + right
		double centerY = PolyPractice.eval(poly, centerX)/2.0;
		double rWidth = Math.abs(sright-sleft); 
		double rHeight = Math.abs(centerY*2.0); 
		
		DrawableShape sliceRec = DrawableShape.createRectangle(centerX, centerY, rWidth, rHeight);
		pframe.addDrawable(sliceRec);
		
	}

}
