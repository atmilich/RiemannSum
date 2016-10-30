package Riemann_Sum;

import java.awt.Color;

import org.opensourcephysics.display.*;
import org.opensourcephysics.frames.PlotFrame;

import polyfun.Polynomial;

public class TrapRule extends Riemann {

	@Override
	/**
	 * Trap slice calculates the area under the curve using a left side, right side, and connects them with a diagonal line instead of a horizontal line like LHR or RHR
	 * 
	 * @param poly - the polynomial
	 * @param sleft - the left endpoint
	 * @param sright - the right endpoint 
	 * 
	 * @return the area of the trapezoid with ends sleft & sright
	 * 
	 */
	public double slice(Polynomial poly, double sleft, double sright) {
		return ((PolyPractice.eval(poly, sleft) + PolyPractice.eval(poly, sright))/2.0)*(sright-sleft);
	}

	@Override
	/**
	 * Graphs the polynomial and the reimann sum calculated with trapezoids
	 * 
	 * @param pframe - The PlotFrame to graph the function
	 * @param poly - the polynomial
	 * @param sleft - the left endpoint of the interval
	 * @param sright - the right endpoint of the interval
	 */
	public void slicePlot(PlotFrame pframe, Polynomial poly, double sleft, double sright) {
		double leftSide = PolyPractice.eval(poly, sleft);
		double delta = sright-sleft;
		double precision = .005;

		Trail trapTrail = new Trail();

		for (double i = sleft; i < sright; i+=precision) {
			trapTrail.addPoint(sleft, 0);
			trapTrail.addPoint(sleft, PolyPractice.eval(poly, sleft));
			trapTrail.addPoint(sleft + delta, PolyPractice.eval(poly, sleft+delta));
			trapTrail.addPoint(sleft + delta, 0);			
		}

		pframe.addDrawable(trapTrail);
		pframe.setVisible(true); 

	}
}
