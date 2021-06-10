import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Steuerung extends Application {

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
    }


    public static void main(String[] args) {
        launch(args);
    }
}
