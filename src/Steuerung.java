import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Steuerung extends Application {

    //Main Timeline
//    private Timeline timeline;
    private AnimationTimer timer;

    //Variable um echte Frame zu speichern
    private Integer i=0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/graphics.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ping Pong by Marc und Colin");
        primaryStage.setAlwaysOnTop(false);
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);
        primaryStage.show();

        //Timeline zum bewegen der Objekte

//        timeline = new Timeline(new KeyFrame(Duration.millis(5), e ->run(ppMain)));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
      /*//Actions für spezifische Frames
        timer = new AnimationTimer() {
            @Override
            public void handle (long now) {
                i++;
            }
        };
      */

   


    }
/*
    private void run(PingPongMain ppMain) {

        if (ppMain.gameGestartet == true) {
            System.out.println("game gestartet");
            ppMain.naechsterGametick();
        }

    }
*/
    /*
    public static void main(String[] args) {
        launch(args);
    }
*/
}
