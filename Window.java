import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    int width = 600, height = 600;

    Rubik rubik = new Rubik();

    public Window(){
        init();
    }

    private void init() {
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rubik.setPreferredSize(new Dimension(width,height));
        addKeyListener(rubik);
        addMouseMotionListener(rubik);
        add(rubik);
        pack();
        setLocationRelativeTo(null);

    }


}
