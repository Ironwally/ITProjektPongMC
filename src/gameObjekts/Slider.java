package gameObjekts;

import javafx.scene.shape.*;

public class Slider extends Objekt{

    protected Rectangle graphic;

    public Slider(Rectangle rgraphic, int posX) {
        pos[0] = posX;
        pos[1] = 350;
        playercontrolled = true;
        graphic = rgraphic;
    }

    public Rectangle getGraphic() {
        return graphic;
    }

    public void setGraphic(Rectangle graphic) {
        this.graphic = graphic;
    }
}
