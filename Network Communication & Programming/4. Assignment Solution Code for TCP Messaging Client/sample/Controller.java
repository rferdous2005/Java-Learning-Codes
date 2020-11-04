package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import networking.Envelope;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Optional;

public class Controller {

    @FXML
    public TextField msgField;
    @FXML
    public Button msgSendButton;

    ObjectOutputStream oos;
    String username;

    @FXML
    ListView clientList;

    @FXML
    TextArea summary;

    @FXML
    TextArea messages;

    @FXML
    Button offlineButton;

    public void offlineClicked(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Header for Going offline alert");
        alert.setContentText("Sure you want to go offline?");

        Optional<ButtonType> option = alert.showAndWait();

        if(option.get() == ButtonType.OK) {
            this.getSummary().appendText("Disconnected from server!\n===================\n");

            Envelope en = new Envelope();
            en.setType("LEAVE");
            en.setFrom(this.username);
            this.getOos().writeObject(en);
        }
    }

    public void sendMessage() throws IOException {
        Envelope en = new Envelope();
        en.setFrom(this.username);
        en.setType("MESSAGE");
        en.setMsg(msgField.getText()+"\n");
        en.setTo(clientList.getSelectionModel().getSelectedItem().toString());
        msgField.setText("");
        this.getOos().writeObject(en);
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public void setOos(ObjectOutputStream oos) {
        this.oos = oos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ListView getClientList() {
        return clientList;
    }

    public TextArea getSummary() {
        return summary;
    }

    public TextArea getMessages() {
        return messages;
    }

    public Button getOfflineButton() {
        return offlineButton;
    }


    public void checkEnter(KeyEvent keyEvent) {

        if(keyEvent.getCode().equals(KeyCode.ENTER)) {
            Platform.runLater(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                sendMessage();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            );

        }
    }
}
