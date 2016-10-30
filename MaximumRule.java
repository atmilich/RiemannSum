package Riemann_Sum;
import org.opensourcephysics.display.DrawableShape;
import org.opensourcephysics.frames.PlotFrame;

import Riemann_Sum.*;
import polyfun.Polynomial;

public class MaximumRule extends Riemann {
	
	/**
	 * Maximum rule compares LHR and RHR and uses the rectangle with the larger area
	 * 
	 * @param poly - the polynomial
	 * @param sleft - the left endpoint
	 * @param sright - the right endpoint
	 * 
	 * @return the rectangle with the greater area (LHR vs. RHR)
	 */
	@Override
	public double slice(Polynomial poly, double sleft, double sright) {
		double leftRec = (sright - sleft) * PolyPractice.eval(poly, sleft);
		double rightRec = (sright - sleft) * PolyPractice.eval(poly, sright);
		
		if(leftRec < rightRec){
			return rightRec;
		}
		
		else
			return leftRec;
	}

	/**
	 * Plots the Reimann sum using maximum
	 * 
	 * @param poly - the polynomial being used
	 * @param sleft - the left endpoint
	 * @param sright - the right endpoint
	 * 
	 */
	
	@Override
	public void slicePlot(PlotFrame pframe, Polynomial poly, double sleft, double sright) {
		double leftRec = (sright - sleft) * PolyPractice.eval(poly, sleft);
		double rightRec = (sright - sleft) * PolyPractice.eval(poly, sright);

		double rWidth = 0;
		double rHeight = 0;
		
		if(leftRec > rightRec){
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
