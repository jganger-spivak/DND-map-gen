import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Display extends JPanel {

    //size of white cube
    private int width;
    private int height;
    private int xPos;
    private int yPos;
    private ArrayList<Rooms> rooms;
    private ArrayList<Coord> halls;
    private ArrayList<boolean> isVertical;
    private Image horizTex;
    private Image vertTex;
    private SimpleRoom[] littlerooms;




    //setting up display, adding cube, adding buttons
    public Display(ArrayList<Rooms> roomList, ArrayList<Coord> hallList, ArrayList<boolean> verts, Image horizTex, Image vertTex){
        setLayout(null);
        repaint();
        rooms = roomList;
        halls = hallList;
        isVertical = verts;
        //littlerooms = smallRoomList;
        width = 25;
        height = 25;
        xPos = 0;
        yPos = 0;
        JButton upButton = new JButton("^");
        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //room.y -= 50;
                repaint();
            }
        });
        upButton.setBounds(400, 100, 50, 50);
        //add(upButton);
        JButton downButton = new JButton("v");
        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //room.y += 50;
                repaint();
            }
        });
        downButton.setBounds(400, 200, 50, 50);
        //add(downButton);
        JButton rightButton = new JButton(">");
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //room.x += 50;
                repaint();
            }
        });
        rightButton.setBounds(450, 150, 50, 50);
        //add(rightButton);
        JButton leftButton = new JButton("<");
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //room.x -= 50;
                repaint();
            }
        });
        leftButton.setBounds(350, 150, 50, 50);
        //add(leftButton);
    }


    public void paintComponent(Graphics g){

        super.paintComponent(g);
        setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        for (int i = 0; i < this.rooms.size(); i++) {
          g.drawImage(rooms.get(i).texture, rooms.get(i).x, rooms.get(i).y, null);
          g.drawRect(rooms.get(i).x, rooms.get(i).y, rooms.get(i).width*20, rooms.get(i).height*20);
          //g.drawString(Integer.toString(i), rooms.get(i).x, rooms.get(i).y);
        }
        for (int i = 0; i < this.halls.size(); i++) {
          if (this.isVertical.get(i)) {
            g.drawImage(this.halls.get(i).x, this.halls.get(i).y, this.vertTex, null);
          } else {
            g.drawImage(this.halls.get(i).x, this.halls.get(i).y, this.horizTex, null);
          }
        }
        
        
        //g.fillRect(xPos, yPos, width, height);

    }



    }
