package gameObjekts;

import java.util.Vector;


public class Objekt {

    protected int[] pos;
    protected int speed = 0;
    protected int[] direc;
    protected boolean playercontrolled;

    public int[] getDirec () {
        return direc;
    }

    public void setDirec (int[] direc) {
        this.direc = direc;
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
