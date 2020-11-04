package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import networking.TCPClient;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));

        Parent root = loader.load();
        Controller fxmlController = (Controller) loader.getController();

        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        primaryStage.setTitle("Messaging Client");
        primaryStage.setScene(new Scene(root, 700, 375));
        primaryStage.show();

        TCPClient tcpClient = new TCPClient(fxmlController);
        tcpClient.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
