package Test_Classes;

import polyfun.*;
import org.opensourcephysics.frames.*;

import Riemann_Sum.*;

public class RSPlotTest 
{
        public static void main(String[] args) 
        {
                LeftHandRule LHR = new LeftHandRule();  //LeftHandRule extends Riemann
                RightHandRule RHR = new RightHandRule();  //RightHandRule extends Riemann
                TrapRule TRAP = new TrapRule(); //Trap Rule
                MidpointRule MID = new MidpointRule(); //Midpoint rule
                MinimumRule MIN = new MinimumRule(); //minimum rule
                MaximumRule MAX = new MaximumRule(); //maximum rule
                RandomRule RAND = new RandomRule(); //random rule
                
                Polynomial p = new Polynomial(new double[] {3,-6,3}); // p=3x^2-6x+3
                
                PlotFrame f = new PlotFrame("x","y","Left Hand Riemann Sum Graph");
                f.setPreferredMinMaxX(-1, 3);
                f.setDefaultCloseOperation(3);
                f.setVisible(true);
                
                PlotFrame g = new PlotFrame("x","y","Right Hand Riemann Sum Graph");
                g.setPreferredMinMaxX(-1, 3);
                g.setDefaultCloseOperation(3);
                g.setVisible(true);
                
                PlotFrame i = new PlotFrame("x","y","Trap Rule Graph");
                i.setPreferredMinMaxX(-1, 3);
                i.setDefaultCloseOperation(3);
                i.setVisible(true);
                
                PlotFrame h = new PlotFrame("x","y","Midpoint Rule Slice");                   
                h.setPreferredMinMaxX(-1, 3);
                h.setDefaultCloseOperation(3);
                h.setVisible(true);
               
                
                PlotFrame j = new PlotFrame("x","y","Minimum Rule Slice");                   
                j.setPreferredMinMaxX(-1, 3);
                j.setDefaultCloseOperation(3);
                j.setVisible(true);
                
                PlotFrame k = new PlotFrame("x","y","Maximum Rule Slice");                   
                k.setPreferredMinMaxX(-1, 3);
                k.setDefaultCloseOperation(3);
                k.setVisible(true);
                
                PlotFrame c = new PlotFrame("x","y","Random Rule Slice");                   
                c.setPreferredMinMaxX(-1, 3);
                c.setDefaultCloseOperation(3);
                c.setVisible(true);
                
                LHR.rsPlot(f, p, 1, 0.01, 0.0, 2.0, 10); // the left hand rule from x=0 to x=2, with 10 rectangles      
                
                RHR.rsPlot(g, p, 1, 0.01, 0.0, 2.0, 10); // the right hand rule from x=0 to x=2, with 10 rectangles
               
                MID.rsPlot(h, p, 1, 0.01, 0.0, 2.0, 10); //midpoint rule ""
                
                TRAP.rsPlot(i, p, 1, 0.01, 0.0, 2.0, 10);
                
                MIN.rsPlot(j, p, 1, 0.01, 0.0, 2.0, 10);
                
                MAX.rsPlot(k, p, 1, 0.01, 0.0, 2.0, 10);
                
                RAND.rsPlot(c, p, 1, 0.01, 0.0, 2.0, 10);
        }
}       
