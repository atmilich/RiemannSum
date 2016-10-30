package Test_Classes;

import Riemann_Sum.*;
import polyfun.Polynomial;
public class RSTest 
{
	public static void main(String[] args) 
	{
		LeftHandRule LHR = new LeftHandRule();  //LeftHandRule extends Riemann
		RightHandRule RHR = new RightHandRule();  //RightHandRule extends Riemann
		TrapRule TR= new TrapRule(); //TrapezoidRule extends Riemann
		MidpointRule MID = new MidpointRule();
		MinimumRule MIN = new MinimumRule();
		MaximumRule MAX = new MaximumRule();
		RandomRule RAND = new RandomRule();

		Polynomial p = new Polynomial(new double[] {0,0,3}); //p=3x^2

		System.out.println(LHR.rs(p, 0.0, 1.0, 2000)+"\n"); //the approximate area under 3x^2, from 0 to 1, using the left hand rule

		System.out.println(RHR.rs(p, 0.0, 1.0, 2000)+"\n"); //the approximate area under 3x^2, from 0 to 1, using the right hand rule
		
		System.out.println(TR.rs(p, 0.0, 1.0, 2000)+"\n"); //the approximate area under 3x^2, from 0 to 1, using the trapezoid rule
		
		System.out.println(MID.rs(p, 0.0, 1.0, 2000)+"\n"); //midpoint rule
		
		System.out.println(MIN.rs(p, -1.0, 1.0, 2000)+"\n"); //minimum rule
		
		System.out.println(MAX.rs(p, -1.0, 1.0, 2000)+"\n"); //maximum rule
		
		System.out.println(RAND.rs(p, -1.0, 1.0, 2000)+"\n"); //random rule
	}
}
