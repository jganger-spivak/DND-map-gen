import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JPanel {

    private int width;
    private int height;
    private int xPos;
    private int yPos;

    public Display(){
        setLayout(null);
        repaint();
        width = 25;
        height = 25;
        xPos = 0;
        yPos = 300;
        JButton upButton = new JButton("^");
        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yPos = yPos - 50;
                repaint();
            }
        });
        upButton.setBounds(400, 100, 50, 50);
        add(upButton);
        JButton downButton = new JButton("v");
        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yPos = yPos + 50;
                repaint();
            }
        });
        downButton.setBounds(400, 200, 50, 50);
        add(downButton);
        JButton rightButton = new JButton(">");
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                xPos = xPos + 50;
                repaint();
            }
        });
        rightButton.setBounds(450, 150, 50, 50);
        add(rightButton);
        JButton leftButton = new JButton("<");
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                xPos = xPos - 50;
                repaint();
            }
        });
        leftButton.setBounds(350, 150, 50, 50);
        add(leftButton);
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        g.fillRect(xPos, yPos, width, height);

    }



    }
