package gameObjekts;

import java.awt.*;

public class Slider extends Objekt{

    protected Rectangle graphic;

    public Slider(Rectangle graphic) {
        playercontrolled = true;
        graphic = graphic;
    }

    public Rectangle getGraphic() {
        return graphic;
    }

    public void setGraphic(Rectangle graphic) {
        this.graphic = graphic;
    }
}
