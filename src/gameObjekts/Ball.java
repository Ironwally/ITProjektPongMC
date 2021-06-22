package gameObjekts;

import gameObjekts.Objekt;
import javafx.scene.shape.Circle;
import javafx.scene.shape.*;


public class Ball extends Objekt {




    protected Circle graphic = new Circle();

    public Ball(Circle rgraphic) {

        direc[0] = 1;
        direc[1] = 1;
        pos[0] = 900;
        pos[1] = 538;
        speed = 1;
        playercontrolled = false;
        graphic = rgraphic;
    }

    public Circle getGraphic() {
        return graphic;
    }

    public void setGraphic(Circle graphic) {
        this.graphic = graphic;
    }

}
