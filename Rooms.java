import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Rooms {

    int x=0;
    int y=0;
    int width = 0;
    int height = 0;

    ArrayList exits;
    BufferedImage texture;
    public Rooms(int x, int y, int width, int height, Image floorTexture) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        texture = new BufferedImage(floorTexture.getHeight(null)*height, floorTexture.getWidth(null)*width, BufferedImage.TYPE_INT_RGB);
        this.textureTile(floorTexture);
        //assign local vars

    }

    public void textureTile(Image floorTile){
        //System.out.println("Got to textureTile");
        //System.out.println("Tiling at width:" + this.width + ", height:" + this.height);
        Graphics g = this.texture.getGraphics();
        for (int i = 0; i < this.width; i++){
            for (int j = 0; j < this.height; j++){
                g.drawImage(floorTile, i*20, j*20, null);
                //System.out.println("Drawing tile at x:" + i + ", y:" + j);
            }
        }
        //g.dispose();
    }
}
