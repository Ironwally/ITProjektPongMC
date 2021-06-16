import gameObjekts.Ball;
import gameObjekts.Objekt;
import gameObjekts.Slider;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    Slider sliderRight = new Slider();

    //Liste aller Objekte, außer dem Ball
    List<Objekt> objektListe = new ArrayList<>();


    //Methoden


    public void moveObjekt(Objekt objekt1){

        int[] newPos = new int[2];
        newPos[0] = objekt1.getPos()[0]+objekt1.getDirec()[0]*objekt1.getSpeed();
        newPos[1] = objekt1.getPos()[1]+objekt1.getDirec()[1]*objekt1.getSpeed();

        objekt1.setPos(newPos);
        objekt1.setDirec();
    }

    public void testHitObjekt(Objekt objekt1){

        boolean hitObjekt= false;

        int[] objektRand = new int[4];
        objektRand[0] = objekt1.getPos()[0]-objekt1.getRadius(); // Ball Aufschlagpunkte auf der X-Koordinate, links
        objektRand[1] = objekt1.getPos()[0]+objekt1.getRadius(); // Ball Aufschlagpunkte auf der X-Koordinate, rechts
        objektRand[2] = objekt1.getPos()[1]-objekt1.getRadius(); // Ball Aufschlagpunkte auf der y-Koordinate, unten
        objektRand[3] = objekt1.getPos()[1]+objekt1.getRadius(); // Ball Aufschlagpunkte auf der Xy-Koordinate, oben

        if (objektRand[0] == 0) {
            // gewonnen

        } else if (objektRand[1] == 1920) {
            //gewonnen
        } else if (objektRand[2] == 0) {
            //querschleger
        } else if (objektRand[3] == 1080) {
            //querschleger
        }

        int[] objektRandGenau = new int[2];

        objektRandGenau[0] = objekt1.getPos()[0]+objekt1.getDirec()[0]*objekt1.getRadius();
        objektRandGenau[1] = objekt1.getPos()[1]+objekt1.getDirec()[1]*objekt1.getRadius();

        int[] posTest = new int[2];
        boolean done = false;

        for objektListe {


            posTest[0] = graphicSliderRight.getX()
            posTest[1] = graphicSliderRight.getY()

        }
        if (hitObjekt == true) {
            hitObjekt(objekt1,objekt2);
        }
    }
    



    public void hitObjekt(Objekt objekt1, Objekt objekt2){

    }






    @Override
    public void initialize (URL location, ResourceBundle resources) {

        //Alle Grafischen Objekte in eine Liste machen
        objektListe.add(graphicSliderRight);
        objektListe.add(graphicSliderLeft);

    }
}
