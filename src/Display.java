import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {

    public Display(){
        setLayout(null);
        repaint;
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 100, 100);

    }

}
