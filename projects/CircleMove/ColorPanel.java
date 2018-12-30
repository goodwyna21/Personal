import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ColorPanel extends JPanel
{
  private int x, y;
  private ArrayList<rect> squares;

  public ColorPanel(Color backColor){
    setBackground(backColor);
    x = 0;
    y = 0;
    squares = new ArrayList<Square>();
    addMouseListener(new PanelListener());
    addMouseMotionListener(new PanelMotionListener());
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
  }

  private class PanelListener extends MouseAdapter{
    public void mousePressed(MouseEvent e){
      x = e.getX();
      y = e.getY();
    }

    //public void keyListener(KeyboardEvent e){
    //}
  }

  private class PanelMotionListener extends MouseMotionAdapter{
    public void mouseDragged(MouseEvent e){
      int newX, newY, dx, dy;

    }
  }
}
