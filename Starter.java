import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.ArrayList;
import java.awt.event.KeyListener;
import javax.swing.Timer;

//****READ THE ATTACHED TEXT FILE FOR DIRECTIONS****
public class Starter
{
    static ArrayList<BallComponent> bList;
    public static void main(String[] args)
    {
        //create a containing window (JFrame)
        JFrame fr = new JFrame("Rect");//constructing new JFrame object and assigning it it to 
        //object reference fr
        bList = new ArrayList<BallComponent>();//constructing a new ArrayList that contains BallComponents
        //set its size
        final int frWIDTH = 600;//final because they do not need to 
        final int frHEIGHT = 600;
        Random gen = new Random();//initializing object reference gen and assigning it to the newly constructed
        //Random object
        fr.setSize(frWIDTH,frHEIGHT);//invoking mutator method setSize upon the object reference fr with explicit parameters
        //of 2 ints
        BallComponent circle = new BallComponent(275,250,50,bList);//create graphical component
        bList.add(circle);//invoking mutator method upon the ArrayList referenced by bList
        class MovementListener implements KeyListener//constructing an internal class that implements/uses KeyListener
        {
            public void keyPressed(KeyEvent e)//method signature for mutator method that requires an explicit parameter of typer KeyEvent
            {
                int i = gen.nextInt(7)+1;
                //instructions for what I want to happen when key is pressed
                //if Q is pressed, invoke increaseR on circle object
                switch(e.getKeyCode())//switch statement to check which key is pressed
                {
                    case KeyEvent.VK_W: circle.decreaseY(); break;//if this case statement is entered invoke
                    //mutator method decreaseY on the object referenced by circle
                    case KeyEvent.VK_S: circle.increaseY(); break;
                    case KeyEvent.VK_D: circle.increaseX(); break;
                    case KeyEvent.VK_A: circle.decreaseX(); break;
                    case KeyEvent.VK_SPACE: circle.changeColor(i); break;
                    case KeyEvent.VK_N: 
                    {                                                
                        int xPos = gen.nextInt(451);//declaring and initializing int xPos to the integer value of accessor method
                        //nextInt with explicit parameter of type int being invoked upon the object referenced by gen
                        int yPos = gen.nextInt(451);
                        int x = gen.nextInt(2)+1;
                        int w = 30;
                        BallComponent bnew = new OtherBalls(xPos,yPos,w, bList);//constructing a new instance of type OtherBalls
                        //passing in explicit parameteres used in the constructor method
                        bList.add(bnew);//invoking the mutator add method with explicit parameter of type Otherballs upon the ArrayList
                        //that contains BallComponent objects referenced by bList
                        Timer t = new Timer(2, bnew);//constructing new timer object referenced by t
                        t.start();//invoking mutator start method upon the newly constructed timer object referenced by t
                        switch (x)
                        {
                            case 1://left right
                            {
                                bnew.increaseX();//invoking mutator method increaseX upon the object referenced by bnew
                                break;
                            }
                            case 2://up down
                            {
                                bnew.increaseY();//invoking mutator method increase upon the object referenced by bnew
                                break;
                            }
                            default:break;
                        }                        
                        fr.add(bnew);//adding the OtherBalls Component to JFrame by using mutator add method
                        fr.setVisible(true);//invoking mutator method setVisible with explicit parameter of true upon the JFrame referenced by fr
                        bnew.animate();//invoking mutator method animate upon the object referenced by bnew                     
                    }
                    break;
                }

            }

            public void keyReleased(KeyEvent e){}//methods found in the KeyListener Interface
            //these two methods must be present in this class to compile even if they aren't being usedbecause this class implements KeyListener
            //and both of these methods are listed in that interface as well as the keyPressed
            public void keyTyped(KeyEvent e){}//methods found in the KeyListener Interface 
        }

        fr.addKeyListener(new MovementListener());
        fr.add(circle);//add graphical component to frame
        fr.setVisible(true);//make frame visible
        circle.animate();//invoking mutator animate method upon the object referenced by cicrle.

    }

}

