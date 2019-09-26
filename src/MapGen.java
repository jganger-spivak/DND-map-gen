import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class MapGen {


    //ints for window size
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    public static void main(String[] args){

        //creating window
        JFrame f = new JFrame("MapGen");
        f.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        f.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        f.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        Image floorTex = ImageIO.read(new File("floor.png"));
        Rooms testRoom = new Rooms(0, 0, 2, 2, floorTex);

        //where graphics is placed
        f.add(new Display());
        f.setVisible(true);





    }

}
