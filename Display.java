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
    private ArrayList<Boolean> isVertical;
    private Image horizTex;
    private Image vertTex;
    




    //setting up display, adding cube, adding buttons
    public Display(ArrayList<Rooms> roomList, ArrayList<Coord> hallList, ArrayList<Boolean> verts, Image horizTex, Image vertTex){
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
        System.out.println(this.halls.size());
        for (int i = 0; i < this.halls.size(); i++) {
          if (this.isVertical.get(i)) {
            System.out.println("Drew vert hall at (" + this.halls.get(i).x + "," + this.halls.get(i).y + ")");
            //g.drawImage(this.vertTex, this.halls.get(i).x, this.halls.get(i).y, null);
            g.drawRect(this.halls.get(i).x, this.halls.get(i).y, 20, 20);
          } else {
            System.out.println("Drew horiz hall at (" + this.halls.get(i).x + "," + this.halls.get(i).y + ")");
            //g.drawImage(this.horizTex, this.halls.get(i).x, this.halls.get(i).y, null);
            g.drawRect(this.halls.get(i).x, this.halls.get(i).y, 20, 20);
          }
        }
        for (int i = 0; i < this.rooms.size(); i++) {
          g.drawImage(rooms.get(i).texture, rooms.get(i).x, rooms.get(i).y, null);
          g.drawRect(rooms.get(i).x, rooms.get(i).y, rooms.get(i).width*20, rooms.get(i).height*20);
          //g.drawString(Integer.toString(i), rooms.get(i).x, rooms.get(i).y);
        }
        
        
        
        //g.fillRect(xPos, yPos, width, height);

    }



    }
