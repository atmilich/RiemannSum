package Riemann_Sum;

import org.opensourcephysics.display.DrawableShape;
import org.opensourcephysics.frames.PlotFrame;

import polyfun.Polynomial;

public class MinimumRule extends Riemann {

	/**
	 * Approximates the area under the curve by comparing LHR and RHR rectangles and using the smaller one
	 * 
	 * @param poly - the polynomial under which the area is being approximated
	 * @param sleft - the left endpoint of the interval
	 * @param sright - the right endpoint of the interval
	 * 
	 * @return the rectangle with the smaller area (RHR vs. LHR)
	 */
	@Override
	public double slice(Polynomial poly, double sleft, double sright) {

		double leftRec = (sright - sleft) * PolyPractice.eval(poly, sleft);
		double rightRec = (sright - sleft) * PolyPractice.eval(poly, sright);

		if(leftRec > rightRec){
			return rightRec;
		}

		else
			return leftRec;
	} 

	/**
	 * Plots the graph of the reimann sum using the minimum rule
	 * 
	 * @param pframe - the PlotFrame
	 * @param poly - the polynomial under which the area is approximated
	 * @param sleft - the left endpoint of the interval
	 * @param sright - the right endpoint of the interval
	 */
	@Override
	public void slicePlot(PlotFrame pframe, Polynomial poly, double sleft, double sright) {

		double leftRec = (sright - sleft) * PolyPractice.eval(poly, sleft);
		double rightRec = (sright - sleft) * PolyPractice.eval(poly, sright);

		double rWidth = 0;
		double rHeight = 0;
		
		if(leftRec < rightRec){
			rWidth = sright-sleft;
			rHeight = PolyPractice.eval(poly, sleft);
		}
		
		else{
			rWidth = sright-sleft;
			rHeight = PolyPractice.eval(poly, sright);
		}
		
		double centerX = rWidth/2.0 + sleft;
		double centerY = rHeight/2.0;
		
		DrawableShape sliceRec = DrawableShape.createRectangle(centerX, centerY, rWidth, rHeight);
		pframe.addDrawable(sliceRec);
	
	}
}
