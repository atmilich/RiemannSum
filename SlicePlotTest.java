package Test_Classes;

import polyfun.*;
import org.opensourcephysics.frames.*;

import Riemann_Sum.LeftHandRule;
import Riemann_Sum.MidpointRule;
import Riemann_Sum.RightHandRule;

public class SlicePlotTest 
{
        public static void main(String[] args) 
        {
                LeftHandRule LHR = new LeftHandRule();  //LeftHandRule extends Riemann
                RightHandRule RHR = new RightHandRule();  //RightHandRule extends Riemann
                MidpointRule MID = new MidpointRule();
        
                Polynomial p = new Polynomial(new double[] {0,4,0,3}); // p=3x^3+4x
                        
                PlotFrame f = new PlotFrame("x","y","Left Hand Slice");
                f.setPreferredMinMaxX(.5, 1.5);
                f.setDefaultCloseOperation(3);                  
                f.setVisible(true);
                        
                PlotFrame g = new PlotFrame("x","y","Right Hand Rule Slice");                   
                g.setPreferredMinMaxX(.5,1.5);
                g.setDefaultCloseOperation(3);
                g.setVisible(true);
                
                PlotFrame h = new PlotFrame("x","y","Midpoint Rule Slice");                   
                h.setPreferredMinMaxX(.5,1.5);
                h.setDefaultCloseOperation(3);
                h.setVisible(true);
                        
                LHR.slicePlot(f, p, 1, 1.1); //a left hand rule slice of 3x^3+4x, from x=1 to x=1.1
                        
                RHR.slicePlot(g, p, 1, 1.1); //a right hand rule slice of 3x^3+4x, from x=1 to x=1.1
                
                MID.slicePlot(h, p, 1, 1.1); //a right hand rule slice of 3x^3+4x, from x=1 to x=1.1
        }
}
