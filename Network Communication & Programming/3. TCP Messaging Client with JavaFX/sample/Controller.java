package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import networking.Envelope;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Optional;

public class Controller {

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

    public void clientListClicked(MouseEvent mouseEvent) {
        Envelope envelope = new Envelope();
        envelope.setFrom(this.username);
        envelope.setTo(clientList.getSelectionModel().getSelectedItem().toString());

        Runnable backTask = new Runnable() {
            @Override
            public void run() {
                try {
                    sendToServer(envelope);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(backTask).start();
    }

    public void sendToServer(Envelope en) throws IOException {
        Envelope en1 = new Envelope(en);
        en1.setType("START");
        this.getOos().writeObject(en1);
        int count=1;

        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        String txt;
        while((txt=br.readLine())!= null) {
            Envelope en2 = new Envelope(en);
            en2.setType("MESSAGE");
            en2.setMsg("Line "+count+": "+txt);
            count++;

            this.getOos().writeObject(en2);
        }
        Envelope en3 = new Envelope(en);
        en3.setType("END");
        this.getOos().writeObject(en3);

    }
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
}
