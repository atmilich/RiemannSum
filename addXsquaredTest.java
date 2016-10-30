package Test_Classes;


import polyfun.Polynomial;
import Riemann_Sum.PolyPractice;

public class addXsquaredTest {

        public static void main(String[] args) 
        {
                PolyPractice popeye = new PolyPractice(); 
                Polynomial poly = new Polynomial(new double[] {-6,-1}); 
                popeye.addXsquared(poly); //popeye adds x^2 to poly, and then both prints and graphs the resulting polynomial
        }
}
