import gameObjekts.Ball;
import gameObjekts.Objekt;
import gameObjekts.Slider;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class PingPongMain implements Initializable {


    //Definitionen

    int punkteL = 0;
    int punkteR = 0;

    double[] newPos = new double[2];
    double[] objektRand = new double[8];

    private Timeline timeline;

    boolean gameGestartet = false;

    //Grafische Oberfläche inits
    @FXML
    private Rectangle graphicSliderRight;
    @FXML
    private Rectangle graphicSliderLeft;
    @FXML
    private Circle graphicball1;
    @FXML
    private BorderPane bPane;
    @FXML
    private Label labelPunkteL;
    @FXML
    private Label labelPunkteR;


    //Liste aller Objekte
    List<Objekt> objektListe = new ArrayList<>();           //Liste aller Objekte
    List<Slider> sliderListe = new ArrayList<>();           //Liste aller Slider
    List<Ball> ballListe = new ArrayList<>();               //Liste aller Bälle

    //Liste aller grafischen Objekte
    List<Rectangle> rectangleList = new ArrayList<>();      //Liste aller Rectangles


    //Methoden
    //movement updaten
    @FXML
    void keyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.W) {
        //    System.out.println("W");
            sliderListe.get(0).setDirecY(1);
            sliderListe.get(0).setSpeed(4);
        }
        if(event.getCode() == KeyCode.S) {

            sliderListe.get(0).setDirecY(-1);
            sliderListe.get(0).setSpeed(4);
        }
    }

    @FXML
    void keyReleased(KeyEvent event) {

        if(event.getCode() == KeyCode.W) {
            System.out.println("released W");
        //    sliderListe.get(0).setDirecY(1);
        //    sliderListe.get(0).setSpeed(4);
        }
        if(event.getCode() == KeyCode.S) {
            System.out.println("released S");
        //    sliderListe.get(0).setDirecY(-1);
        //    sliderListe.get(0).setSpeed(4);
        }
    }

    //Spiel starten
    public void gameStarten() {
        gameGestartet = true;
        ballListe.get(0).setSpeed(5);
    }

    public void gameStoppen() {

        gameGestartet = false;
        for (Ball ball : ballListe) resetBall(ball);
        for (Slider slider : sliderListe) resetSlider(slider);
        updateGrafik();
    }

    public void updateGrafik() {                            //Updatet die GUI

        for (Slider slider : sliderListe) {

            slider.getGraphic().setLayoutX(slider.getPos()[0]);
            slider.getGraphic().setLayoutY(slider.getPos()[1]);
        }

        for (Ball ball : ballListe) {

            ball.getGraphic().setLayoutX(ball.getPos()[0]);
            ball.getGraphic().setLayoutY(ball.getPos()[1]);
        }

    }

    public void naechsterGametick() {                       //Einmal pro Gametick aufgerufen

        if (gameGestartet == true) {
            System.out.println("gametick");
            moveObjekts();
            updateGrafik();                                     //Nach dem Parameter geändert wurden, werden die Positionen der grafischen Objekte geupdatet
        }
    }
    public void moveObjekts() {                                                                                         //Alle Objekte Position verändern

        for (Slider slider : sliderListe) {                                                                             //Slider bewegen

            double[] newPos = new double[2];
            newPos[0] = slider.getPos()[0];
            newPos[1] = slider.getPos()[1] + slider.getDirec()[1] * slider.getSpeed();
            slider.setPos(newPos);

        }

        for (Ball ball : ballListe) {                                                                                   //Bälle bewegen

            System.out.println("Ball bewegung");
            testHitObjekt(ball);

            double[] newPos = new double[2];
            newPos[0] = ball.getPos()[0] + ball.getDirec()[0] * ball.getSpeed();
            newPos[1] = ball.getPos()[1] + ball.getDirec()[1] * ball.getSpeed();
            ball.setPos(newPos);
        }
                                                                                                                        //Kategorien sind absichtlich getrennt, um die Übersichtlichkeit zu verbessern

    }

    public void resetSlider(Slider slider) {
        newPos[0] = slider.getPos()[0];
        newPos[1] = 350;
        slider.setPos(newPos);
    }

    public void resetBall(Ball ball) {

        ball.setSpeed(1);
        do {
            ball.setDirecX(new Random().nextInt((1 + 2))-1);
        } while(ball.getDirec()[0] == 0);

        ball.setDirecY((Math.random()*((1 + 1))-1));
        newPos[0] = 900;
        newPos[1] = 538;
        ball.setPos(newPos);

    }

    public void testHitObjekt(Ball testBall) {

    //    double[] objektRandGenau = new double[2];


        objektRand[0] = testBall.getPos()[0] - testBall.getRadius(); // Ball Aufschlagpunkte auf der X-Koordinate, links
        objektRand[1] = testBall.getPos()[1];                     // Ball Aufschlagpunkte auf der y-Koordinate, links
        objektRand[2] = testBall.getPos()[0];                     // Ball Aufschlagpunkte auf der x-Koordinate, unten
        objektRand[3] = testBall.getPos()[1] - testBall.getRadius(); // Ball Aufschlagpunkte auf der y-Koordinate, unten

        objektRand[4] = testBall.getPos()[0] + testBall.getRadius(); // Ball Aufschlagpunkte auf der X-Koordinate, rechts
        objektRand[5] = testBall.getPos()[1];                     // Ball Aufschlagpunkte auf der y-Koordinate, rechts
        objektRand[6] = testBall.getPos()[0];                     // Ball Aufschlagpunkte auf der x-Koordinate, oben
        objektRand[7] = testBall.getPos()[1] + testBall.getRadius(); // Ball Aufschlagpunkte auf der y-Koordinate, oben

        if (objektRand[0] == 0) {                                 //Rechts bekommt einen Punkt, da Ball linke Wand berührt hat
            punkteR += 1;
            labelPunkteR.setText(String.valueOf(punkteR));
            resetBall(testBall);
        } else if (objektRand[4] == 1920) {                       //Links bekommt einen Punkt, da Ball rechte Wand berührt hat
            punkteL += 1;
            labelPunkteL.setText(String.valueOf(punkteL));
            resetBall(testBall);
        } else if (objektRand[3] == 0 || objektRand[7] == 1080) { //Ball trifft Decke, oder Boden, Ball prallt ab
            //querschleger
            testBall.setDirecY(testBall.getDirec()[1] * (-1));
        }

    //    objektRandGenau[0] = testBall.getPos()[0] + testBall.getDirec()[0] * testBall.getRadius();
    //    objektRandGenau[1] = testBall.getPos()[1] + testBall.getDirec()[1] * testBall.getRadius();

        boolean posTest = false;

        for (Slider slider : sliderListe) {                                                     //alle Slider durch checken ob sie den Ball treffen

            for (int i = 0; i < 7; i += 2) {
                posTest = slider.getGraphic().contains(objektRand[i], objektRand[i + 1]);
                if (posTest == true) {
                    if (i <= 0 || i == 4) {                                                     //Wenn der Ball den Slider trifft, dann X- oder Y-Richtung umkehren
                        testBall.setDirecX(testBall.getDirec()[0] * (-1));
                    } else if (i == 2 || i == 6) {
                        testBall.setDirecY(testBall.getDirec()[1] * (-1));
                    }
                    break;
                }
            }
            if (posTest) break;
        }
    }



    //Wird nach start der Oberfläche aufgerufen

    @Override
    public void initialize (URL location, ResourceBundle resources) {

        //gameObjekts.Objekt inits
        Ball ball1 = new Ball(graphicball1);                    //Objekt Ball mit seiner Grafik erstellen
        Slider sliderRight = new Slider(graphicSliderRight, 1856);    //Objekt Slider rechts mit seiner Grafik erstellen
        Slider sliderLeft = new Slider(graphicSliderLeft, 14);      //Objekt Slider links mit seiner Grafik erstellen

        //Alle Grafischen Slider in eine Liste schreiben
        sliderListe.add(sliderLeft);
        sliderListe.add(sliderRight);

        //Alle Rectangeles in Liste schreiben
        rectangleList.add(graphicSliderLeft);
        rectangleList.add(graphicSliderRight);

        //Alle grafischen Bälle in eine Liste schreiben
        ballListe.add(ball1);

        //Alle Objekte in eine Liste schreiben
        objektListe.addAll(ballListe);
        objektListe.addAll(sliderListe);

        timeline = new Timeline(new KeyFrame(Duration.millis(10), e ->naechsterGametick()));                            //Ruft einmal alle 10 millis naechsterGametick() auf und ->Bestimmt Spielgeschwindigkeit
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
      //  bPane.setOnKeyPressed(e -> sliderLeft.getGraphic().setLayoutX(sliderLeft.getGraphic().getLayoutX()+1));
    }
}
