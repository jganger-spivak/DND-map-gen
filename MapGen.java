import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.util.Random;

public class MapGen {


    //ints for window size
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final int NUMROOMS = 30;
    public static void main(String[] args)  {
      
        //creating window
        JFrame f = new JFrame("MapGen");
        Random rand = new Random();
        f.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        f.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        f.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        Image floorTex;
        Image hallHoriz;
        Image hallVert;
        ArrayList<Rooms> roomList = new ArrayList<Rooms>();
        
        ArrayList<Coord> roomsPlaced = new ArrayList<Coord>();
        ArrayList<Coord> halls = new ArrayList<Coord>();
        ArrayList<Boolean> isVert = new ArrayList<Boolean>();
        int nextx = 20;
        int nexty = 20;
        
        try {
            floorTex = ImageIO.read(new File("floor.png"));
            hallHoriz = ImageIO.read(new File("corridorHorizontal.png"));
            hallVert = ImageIO.read(new File("corridorVertical.png"));
            
            roomsPlaced.add(new Coord(nextx, nexty));
            roomList.add(new Rooms(nextx, nexty, 3, 3, floorTex));
            System.out.println(roomsPlaced.size());
            for (int i = 1; i < NUMROOMS; i++) {
              /*
              int nextx = (rand.nextInt(19)+1)*20;
              int nexty = (rand.nextInt(19)+1)*20;
              int nextwidth = rand.nextInt(3)+1;
              int nextheight = rand.nextInt(3)+1; */
        
              
              
              
              int posnextx = 0;
              int posnexty = 0;
              posnextx = nextx + (rand.nextInt(3)-1)* (rand.nextInt(2)+1)*80;
              posnexty = nexty + (rand.nextInt(3)-1)* (rand.nextInt(2)+1)*80;
              if ((posnextx > 420) || (posnextx < 0)){
                continue;
              }
              if ((posnexty > 420) || (posnexty < 0)){
                continue;
              }
              
              
              nextx = posnextx;
              nexty = posnexty;
              
              for (int j = 0; j < roomsPlaced.size(); j++) {
                if (roomsPlaced.get(j).x == nextx) {
                  if (roomsPlaced.get(j).y == nexty) {
                    continue;
                  }
                }
                
              }
              roomList.add(new Rooms(nextx, nexty, 3, 3, floorTex));
              roomsPlaced.add(new Coord(nextx, nexty));
              
              
              
            }
            for (int i = 0; i < roomList.size()-1; i++) {
              if (i == 0) {
                halls.add(new Coord(40, 0));
                isVert.add(true);
              }
              int diffX = roomList.get(i).x - roomList.get(i+1).x;
              int diffY = roomList.get(i).y - roomList.get(i+1).y;
              System.out.println(diffX);
              System.out.println(diffY);
              if (diffX > 0) {
                for (int j = roomList.get(i).x; j < diffX; j += 20) {
                  halls.add(new Coord(j, roomList.get(i).x));
                  isVert.add(false);
                }
              } else {
                for (int j = roomList.get(i).x; j > diffX; j -= 20) {
                  halls.add(new Coord(j, roomList.get(i).x));
                  isVert.add(false);
                }
              }
              
              if (diffY > 0) {
                for (int j = roomList.get(i).y; j < diffY; j += 20) {
                  halls.add(new Coord(roomList.get(i).y, j));
                  isVert.add(true);
                }
              } else {
                for (int j = roomList.get(i).y; j > diffY; j -= 20) {
                  halls.add(new Coord(roomList.get(i).y, j));
                  isVert.add(true);
                }
              }
              
            }
            
            f.add(new Display(roomList, halls, isVert, hallHoriz, hallVert));
            f.setVisible(true);
        } catch (IOException e) {
            System.out.println("Failed to load image");
        }




        //where graphics is placed
        





    }

}
