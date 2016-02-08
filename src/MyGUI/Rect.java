package MyGUI;

import java.awt.*;

/**
 * Created by Adrian on 04-02-2016.
 */
public class Rect extends Rectangle{
    public Rect(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getRectX() {
        return (int)super.getX();
    }

    public int getRectY(){
        return (int)super.getY();
    }

    public int getRectWidth(){
        return (int)super.getWidth();
    }

    public int getRectHeight(){
        return (int)super.getHeight();
    }

    @Override
    public String toString() {
        return "(X:"+x+", Y:"+y+", W:"+width+", H:"+height+")";
    }
}
