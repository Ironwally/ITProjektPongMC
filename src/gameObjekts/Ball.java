package gameObjekts;

import gameObjekts.Objekt;
import javafx.scene.shape.Circle;

public class Ball extends Objekt {




    protected Circle graphic;

    public Ball(Circle graphic) {

        playercontrolled = false;
        graphic = graphic;
    }

    public Circle getGraphic() {
        return graphic;
    }

    public void setGraphic(Circle graphic) {
        this.graphic = graphic;
    }

}
