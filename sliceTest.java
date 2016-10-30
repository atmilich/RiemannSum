package Test_Classes;

import Riemann_Sum.LeftHandRule;
import Riemann_Sum.MidpointRule;
import Riemann_Sum.RightHandRule;
import Riemann_Sum.TrapRule;
import Riemann_Sum.MidpointRule;
import polyfun.Polynomial;

public class sliceTest 
{
        public static void main(String[] args) 
        {
                LeftHandRule LHR = new LeftHandRule();  //LeftHandRule extends Riemann
                RightHandRule RHR = new RightHandRule();  //RightHandRule extends Riemann
                TrapRule TR = new TrapRule(); //TrapezoidRule extends Riemann
                MidpointRule MID = new MidpointRule(); //MidpointRule extends Riemann
        
                Polynomial p = new Polynomial(new double[] {0,4,0,3}); // p=3x^3+4x
                
                System.out.println(LHR.slice(p,1,1.1)+"\n"); //the area of a left hand rule slice of 3x^3+4x, from x=1 to x=1.1
                
                System.out.println(RHR.slice(p,1,1.1)+"\n"); //the area of a right hand rule slice of 3x^3+4x, from x=1 to x=1.1
                
                System.out.println(TR.slice(p,1,1.1)+"\n"); //the area of a trapezoid rule slice of 3x^3+4x, from x=1 to x=1.1
                
                System.out.println(MID.slice(p,1,1.1)+"\n"); //midpoint rule
        }
}
