package Test_Classes;

import polyfun.Polynomial;
import org.opensourcephysics.frames.*;

import Riemann_Sum.*;

public class RSAccTest 
{
        public static void main(String[] args) 
        {
                LeftHandRule LHR = new LeftHandRule();  //LeftHandRule extends Riemann
                RightHandRule RHR = new RightHandRule();  //RightHandRule extends Riemann
                TrapRule TR= new TrapRule(); //TrapezoidRule extends Riemann
                MaximumRule MAX = new MaximumRule(); //maximum rule acc function
                        
                Polynomial p = new Polynomial(new double[] {0,1,1}); // p=x^2+x
        
                PlotFrame f = new PlotFrame("x","y","Left Hand Rule Accumulation Function Graph");
                f.setPreferredMinMaxX(-3, 3);
                f.setDefaultCloseOperation(3);
                f.setVisible(true);
                        
                PlotFrame g = new PlotFrame("x","y","Right Hand Rule Accumulation Function Graph");
                g.setPreferredMinMaxX(-3, 3);
                g.setDefaultCloseOperation(3);
                g.setVisible(true);
                        
                PlotFrame i = new PlotFrame("x","y","Trapezoid Rule Accumulation Function Graph");
                i.setPreferredMinMaxX(-3, 3);
                i.setDefaultCloseOperation(3);                  
                i.setVisible(true);
                
                PlotFrame j = new PlotFrame("x","y","Maximum Rule Accumulation Function Graph");
                j.setPreferredMinMaxX(-3, 3);
                j.setDefaultCloseOperation(3);                  
                j.setVisible(true);
                        
                LHR.rsAcc(f, p, 2, .01, -1.0); //plots the left hand rule accumulation function of x^2+x, with base x=-1;
                        
                RHR.rsAcc(g, p, 2, .01, -1.0); //plots the right hand rule accumulation function of x^2+x, with base x=-1;
                        
                TR.rsAcc(i, p, 2, .01, -1.0); //plots the trapezoid rule accumulation function of x^2+x, with base x=-1;       
        
                MAX.rsAcc(j, p, 2, .01, -1.0); //plots accumulation function with max rule
        }
}     