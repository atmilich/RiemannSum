package Riemann_Sum;

import Riemann_Sum.*;

import java.util.Random;

import org.opensourcephysics.display.DrawableShape;
import org.opensourcephysics.frames.PlotFrame;

import polyfun.Polynomial;

public class RandomRule extends Riemann {
	
	Random rand = new Random();
	double randNum = rand.nextDouble();
	
	/**
	 * Random rule: Calculate the reimann sum using a random point to calculate the height in each rectangle
	 * 
	 * @param poly - The polynomial being used
	 * @param sleft - the left most side of the interval inside which the reimann sum is being calculated
	 * @param sright - the right most side of the interval inside which the reimann sum is being calculated
	 * 
	 * @return each base multiplied by a height randomly chosen (random area of a rectangle)
	 */
	
	@Override
	public double slice(Polynomial poly, double sleft, double sright) {
		return (sright-sleft)*PolyPractice.eval(poly, sleft + (sright-sleft)*randNum);
	}

	/**
	 * 
	 * @param pFrame - plot frame to graph random rule
	 * @param poly - the polynomial being used
	 * @param sleft - the left most side of the interval inside which the reimann sum is being calculated
	 * @param sright - the right most side of the interval inside which the reimann sum is being calculated
	 * 
	 * Graph the Random Rule
	 */
	
	@Override
	public void slicePlot(PlotFrame pframe, Polynomial poly, double sleft, double sright) {
		double centerX = (sright+sleft)/2.0;
		double centerY = PolyPractice.eval(poly, sleft + (sright-sleft)*randNum)/2.0; //centerY needs to use randNum generated
		double width = Math.abs(sright-sleft); 
		double height = Math.abs(centerY*2.0); 

		DrawableShape sliceRec = DrawableShape.createRectangle(centerX,centerY,width,height); 
		pframe.addDrawable(sliceRec); 
		pframe.setVisible(true); 
		
	}

}
