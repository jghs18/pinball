import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.util.ArrayList;
public class OtherBalls extends BallComponent implements ActionListener//is a type of BallComponent
//inherits all methods and instance fields from BallComponent
{
    ArrayList<BallComponent> bList;//declaring bList as an ArrayList that contains ballComponents
    public OtherBalls(int xPos, int yPos, int w, ArrayList<BallComponent> b)
    {
        super(xPos, yPos, w, b);//call to the SuperConstructor
        bList = b;//initializing instance field variables
    }

    public void actionPerformed(ActionEvent e)
    {
        y+=dY;//mutating the y value/position
        x+=dX;//mutating the x value/position
        //Bouncing off the wall
        if (x>550) dX = dX * (-1);//if the ball is too far right negate the value of dX to make the ball bounce left
        if (x<0) dX = dX *(-1);//if the ball is too far left, negate the value of dX to make the ball bounce right
        if (y>525) dY = dY * (-1);//if the ball is too far down, negate the value of dY to make the ball bounce upwards
        if (y<0) dY = dY *(-1);//if the ball is to far up, negate the value of dY to make the ball bounce downwards
        BallComponent bC = bList.get(0);//Constructing new BallComponent object and initializing it to
        //the Ballcomponent located in the 0 position of the ArrayList
        //assigning the object referenced by bC to the BallComponent returned by accessor method get  with explicit parameter 0 invoked on the ArrayList
        //referenced by bList
        for (BallComponent b : bList)//generalized for loop to check through every ball in ArrayList
        {           
            int xI = Math.abs(bC.x-b.x);//decalring int xI and assigning it to the integer value of static accessor method
            //abs being invoked on class math with an explicit parameter of type int
            int yI = Math.abs(bC.y-b.y);//decalring int yI and assigining it to the integer value of static accessor method
            //abs invoked upon the class Math with explicit parameter of type int
            if (xI < 10 && yI < 10)//checks to see if the balls are touching so that they can bounce
            {
                bC.switchDirection();//invoking mutator method switchDirection upon the object referenced by bC              
                b.switchDirection();
            }
        }
    }
    
    
}
