import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JPanel {

    private int width;
    private int height;

    public Display(){
        setLayout(null);
        repaint();
        width = 100;
        height = 100;
        JButton button = new JButton("Expand");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                width = 200;
                height = 200;
                repaint();
            }
        });
        button.setBounds(400, 100, 120, 30);
        add(button);
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

    }

}
