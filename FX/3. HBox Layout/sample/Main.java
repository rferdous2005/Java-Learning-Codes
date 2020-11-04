package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Hello FX");
        primaryStage.setScene(new Scene(root, 700, 375));
        primaryStage.show();
    }

    // we can also define init() and stop(). We will see later

    public static void main(String[] args) {
        launch(args);
    }
}
