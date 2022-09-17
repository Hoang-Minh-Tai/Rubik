import core.Matrix;
import core.Vector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

import static java.lang.Math.*;
import static util.Util.*;

public class Rubik extends JPanel implements KeyListener, MouseMotionListener {
    //List of all the points represented
    LinkedList<Vector> points = new LinkedList<>();


    public Rubik() {
        Vector a = new Vector(100,100,-100);
        Vector b = new Vector(-100,100,-100);
        Vector c = new Vector(-100,-100,-100);
        Vector d = new Vector(100,-100,-100);
        Vector a1 = new Vector(100,100, 100);
        Vector b1 = new Vector(-100,100,100);
        Vector c1 = new Vector(-100,-100,100);
        Vector d1 = new Vector(100,-100,100);
        points.add(a);
        points.add(b);
        points.add(c);
        points.add(d);
        points.add(a1);
        points.add(b1);
        points.add(c1);
        points.add(d1);
    }

    private void rotate(Vector base) {
        double tan = base.Y() / base.X();
        double deg = toDegrees(atan(tan));
        deg = toRadians(deg);
        Matrix changeBase = new Matrix(cos(deg),-sin(deg),0,sin(deg),cos(deg),0,0,0,1);
        Matrix changeBaseInv = new Matrix(cos(deg),+sin(deg),0,-sin(deg),cos(deg),0,0,0,1);

        for (int i = 0; i < points.size(); i++) {
            Vector v = points.get(i);
            v = matrixMultiVector(changeBase, v);
            v = matrixMultiVector(base.X() < 0 ? rotate1 : rotate2, v);
            v = matrixMultiVector(changeBaseInv, v);
            points.set(i, v);
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(Color.white);
        for (Vector v : points) {
            g.fillOval((int) (v.X() + 300), (int) (v.Y() + 300), (int) (20 + v.Z() / 10), (int) (20 + v.Z() / 10));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent z) {
        if (z.getKeyCode() == KeyEvent.VK_A) {
            rotate(OY);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    int lastX,lastY;
    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        double difX = x - lastX;
        double difY = y - lastY;
        lastX = x;
        lastY = y;

        rotate(new Vector(difX,difY,0));
    }


    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
