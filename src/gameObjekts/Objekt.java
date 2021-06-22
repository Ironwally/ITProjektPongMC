package gameObjekts;

import java.util.Vector;
import javafx.scene.shape.*;

public class Objekt {

    protected double[] pos = new double[2];
    protected int speed = 0;
    protected double[] direc = new double[2];
    protected boolean playercontrolled;
    protected int radius = 30;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


    public double[] getDirec () {
        return direc;
    }

    public void setDirec (double[] direc) {
        this.direc = direc;
    }

    public void setDirecX (double direcX) {
        this.direc[0] = direcX;
    }
    public void setDirecY (double direcY) { this.direc[1] = direcY; }

    public double[] getPos () {
        return pos;
    }

    public void setPos (double[] pos) {
        this.pos = pos;
    }

    public int getSpeed () {
        return speed;
    }

    public void setSpeed (int speed) {
        this.speed = speed;
    }


}
