import javax.swing.*;
import java.awt.*;

public class CircleMove
{
    public static void main(String[] args)
    {
        JFrame myGUI = new JFrame();
        myGUI.setTitle("Circles");
        myGUI.setSize(900, 900);
        myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container pane = myGUI.getContentPane();
        ColorPanel panel = new ColorPanel(Color.WHITE);
        pane.add(panel);
        
        myGUI.setVisible(true);
    }
}