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
        textureTile(floorTexture);
        //assign local vars

    }
    public void render(Graphics g){



        g.drawImage(texture, x, y, null);
    }
    public void textureTile(Image floorTile){
        Graphics g = this.texture.getGraphics();
        for (int i = 0; i < this.width; i++){
            for (int j = 0; j < this.height; j++){
                g.drawImage(floorTile, i, j, null);
            }
        }
        g.dispose();
    }
}
