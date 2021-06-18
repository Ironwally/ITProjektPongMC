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
    double[] objektRand = new double[8];
    double[] objektRandGenau = new double[2];

    //Grafische Oberfläche inits
    @FXML
    private Rectangle graphicSliderRight;
    @FXML
    private Rectangle graphicSliderLeft;
    @FXML
    private Circle graphicBall1;

    //gameObjekts.Objekt inits
    Ball ball1 = new Ball(graphicBall1);                    //Objekt Ball mit seiner Grafik erstellen
    Slider sliderRight = new Slider(graphicSliderRight);    //Objekt Slider rechts mit seiner Grafik erstellen
    Slider sliderLeft = new Slider(graphicSliderLeft);      //Objekt Slider links mit seiner Grafik erstellen

    //Liste aller Objekte, außer dem Ball
    List<Slider> sliderListe = new ArrayList<>();           //Liste aller Slider


    //Methoden

    public void updateGrafik() {                            //Updatet die GUI

    }

    public void naechsterGametick() {                       //Einmal pro Gametick aufgerufen -> Bestimmt Spielgeschwindigkeit

        testHitObjekt(ball1);

        updateGrafik();                                     //Nach dem Parameter geändert wurden, werden die Positionen der Grafischen Positionen geupdatet
    }
    public void moveObjekt(Objekt objekt1){

        int[] newPos = new int[2];
        newPos[0] = objekt1.getPos()[0]+objekt1.getDirec()[0]*objekt1.getSpeed();
        newPos[1] = objekt1.getPos()[1]+objekt1.getDirec()[1]*objekt1.getSpeed();

        objekt1.setPos(newPos);
        objekt1.setDirec();
    }

    public void testHitObjekt(Objekt objekt1){

        boolean hitObjekt= false;

        objektRand[0] = objekt1.getPos()[0]-objekt1.getRadius(); // Ball Aufschlagpunkte auf der X-Koordinate, links
        objektRand[1] = objekt1.getPos()[1];                     // Ball Aufschlagpunkte auf der y-Koordinate, links
        objektRand[2] = objekt1.getPos()[0];                     // Ball Aufschlagpunkte auf der x-Koordinate, unten
        objektRand[3] = objekt1.getPos()[1]-objekt1.getRadius(); // Ball Aufschlagpunkte auf der y-Koordinate, unten

        objektRand[4] = objekt1.getPos()[0]+objekt1.getRadius(); // Ball Aufschlagpunkte auf der X-Koordinate, rechts
        objektRand[5] = objekt1.getPos()[1];                     // Ball Aufschlagpunkte auf der y-Koordinate, rechts
        objektRand[6] = objekt1.getPos()[0];                     // Ball Aufschlagpunkte auf der x-Koordinate, oben
        objektRand[7] = objekt1.getPos()[1]+objekt1.getRadius(); // Ball Aufschlagpunkte auf der y-Koordinate, oben

        if (objektRand[0] == 0) {
            // gewonnen

        } else if (objektRand[4] == 1920) {
            //gewonnen
        } else if (objektRand[3] == 0) {
            //querschleger
        } else if (objektRand[7] == 1080) {
            //querschleger
        }



        objektRandGenau[0] = objekt1.getPos()[0]+objekt1.getDirec()[0]*objekt1.getRadius();
        objektRandGenau[1] = objekt1.getPos()[1]+objekt1.getDirec()[1]*objekt1.getRadius();

        boolean posTest;
        boolean done = false;

        for (Slider slider : sliderListe) {

            for (int i=0;i<4;i++) {
                posTest = slider.getGraphic().contains(objektRand[i], objektRand[i+1]);

            }
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
        sliderListe.add(sliderLeft);
        sliderListe.add(sliderRight);

    }
}
