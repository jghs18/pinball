import javax.swing.JComponent;
import java.awt.geom.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.util.ArrayList;
public class BallComponent extends JComponent implements ActionListener//is a type of JComponent and it uses ActionListener
{
    int x,y,dX,dY,r,gr,b,width;//declaring instance field variables
    public BallComponent(int xPos, int yPos, int w, ArrayList bk)
    {
        //initializing instance field variables
        x = xPos;
        y = yPos;   
        width = w;
        dX = 0;
        dY = 0;
        r = 0;
        gr = 0;
        b = 0;
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;//constructing new Graphics2D object and initializing it to the object reference g2
        
        g2.setColor(new Color(r,gr,b));//invoking mutator method setColor with an explicit parameter of type color upon the
        //object referenced by g2
        g2.fill(new Ellipse2D.Double(x,y,width,width));//invoking mutator method fill upon the object referenced by g2
        
    }
    public void actionPerformed(ActionEvent e)//method found in the ActionListener interface
    {
        y+=dY;
        x+=dX;
        if (x>550) dX = dX * (-1); 
        if (x<0) dX = dX *(-1);
        if (y>525) dY = dY * (-1); 
        if (y<0) dY = dY *(-1);
        repaint();
    }
    public void changeColor(int i)//method signature for mutator method changeColor which requires an int as an explicit parameter
    {
        switch (i)
        {
            case 1://blue
            {
                r = 5;
                gr = 37;
                b = 247;
                break;
            }
            case 2://red
            {
                r = 255;
                gr = 0;
                b = 0;
                break;
            }
            case 3://green
            {
                r = 5;
                gr = 247;
                b = 13;
                break;
            }
            case 4://pink
            {
                r = 245;
                gr = 10;
                b = 237;
                break;
            }
            case 5://orange
            {
                r = 245;
                gr = 190;
                b = 10;
                break;
            }
            case 6://purple
            {
                r = 170;
                gr = 10;
                b = 245;
                break;  
            }
            case 7://yellow
            {
                r = 242;
                gr = 250;
                b = 5;
                break;
            }
            case 8://lightblue
            {
                r = 0;
                gr = 221;
                b = 250;
                break;
            }
            default:break;
        }
        repaint();
    }
    public void animate()//method signature for mutator animate method
    {
        Timer t = new Timer(1, this);//constructing new Timer object referenced by t
        t.start();//invoking the mutator start method upon the object refereneced by t
    }
    public void increaseX()//method signature ofr mutator method increaseX that mutatutes the value of instance field variable dX
    {
        dX += 1;        
        repaint();
    }
    public void decreaseX()//method signature for mutator method decreaseX
    {
        dX -= 1;
        repaint();
    }
    public void increaseY()
    {
        dY += 1 ;
        repaint();
    }
    public void decreaseY()
    {
        dY -= 1;
        repaint();
    }
    public void switchDirection()
    {
        //casues the ball to bounce
        dX = dX *(-1);
        dY = dY *(-1);
    }
    public void reset()
    {
        this.x = 275;//changing the value of the x instance field variable
        this.y = 250;
        dX = 0;
        dY = 0;
    }
    
    
    
}
