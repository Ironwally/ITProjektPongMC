package gameObjekts;

import java.util.Vector;
import javafx.scene.shape.*;

public class Objekt {

    protected int[] pos;
    protected int speed = 0;
    protected int[] direc;
    protected boolean playercontrolled;
    protected int radius = 30;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


    public int[] getDirec () {
        return direc;
    }

    public void setDirec (int[] direc) {
        this.direc = direc;
    }

    public void setDirecX (int direcX) {
        this.direc[0] = direcX;
    }
    public void setDirecY (int direcY) {
        this.direc[1] = direcY;
    }

    public int[] getPos () {
        return pos;
    }

    public void setPos (int[] pos) {
        this.pos = pos;
    }

    public int getSpeed () {
        return speed;
    }

    public void setSpeed (int speed) {
        this.speed = speed;
    }


}
