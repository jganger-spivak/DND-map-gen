import javax.swing.*;
import java.awt.*;

public class MapGen {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    public static void main(String[] args){

        JFrame f = new JFrame("MapGen");
        f.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        f.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        f.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(new Display());
        f.setVisible(true);



    }

}
