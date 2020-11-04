package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.web.WebView;

public class Controller {

    @FXML
    public WebView webSpace;

    @FXML
    public TextField urlField;

    public void keyCheck(KeyEvent keyEvent) {

        if(keyEvent.getCode().equals(KeyCode.ENTER)) {

            webSpace.getEngine().load(urlField.getText().trim());


        }
    }
}
