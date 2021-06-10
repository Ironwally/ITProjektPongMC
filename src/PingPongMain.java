import gameObjekts.Ball;
import gameObjekts.Objekt;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class PingPongMain implements Initializable {

    //Definitionen


    //Grafische Oberfläche inits
    @FXML
    private Rectangle graphicSliderRight;
    @FXML
    private Rectangle graphicSliderLeft;
    @FXML
    private Circle graphicBall1;

    //gameObjekts.Objekt inits
    Ball ball1 = new Ball();



    //Methoden

    public void moveObjekt(Objekt objekt1){

        int[] newPos = new int[2];
        newPos[0] = objekt1.getPos()[0]+objekt1.getDirec()[0]*objekt1.getSpeed();
        newPos[1] = objekt1.getPos()[1]+objekt1.getDirec()[1]*objekt1.getSpeed();

        objekt1.setPos(newPos);
    }

    public void testHitObjekt(Objekt objekt1){

        boolean hitObjekt= false;




        if (hitObjekt == true) {
            hitObjekt(objekt1,objekt2);
        }
    }



    public void hitObjekt(Objekt objekt1, Objekt objekt2){

    }






    @Override
    public void initialize (URL location, ResourceBundle resources) {

    }
}
