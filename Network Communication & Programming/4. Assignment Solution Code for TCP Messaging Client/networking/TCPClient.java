package networking;

import javafx.application.Platform;
import sample.Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPClient extends Thread {
    Controller controller;
    Socket socket;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    long start, end;
    int port = 12556;

    public TCPClient(Controller c) {
        this.controller = c;
        try {
            this.socket = new Socket("127.0.0.1", this.port);
            this.oos = new ObjectOutputStream(this.socket.getOutputStream());
            this.ois = new ObjectInputStream(this.socket.getInputStream());
            this.controller.setOos(this.oos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        int count=0;
        while(true) {
            try {
                Envelope envelope = (Envelope) this.getOis().readObject();

                if(envelope.getType().equals("NAME")) {
                    this.getController().setUsername(envelope.getMsg());
                } else if(envelope.getType().equals("JOIN")) {
                    this.updateSummary(envelope.getFrom()+" Joined");
                    this.updateClientList(envelope.getFrom());
                } else if(envelope.getType().equals("START")) {
                    start = System.currentTimeMillis();

                } else if(envelope.getType().equals("END")) {
                    end = System.currentTimeMillis();
                    this.updateSummary("From: "+envelope.getFrom()+"\nReceived "+count
                                        +" lines\nTime: "+(end-start)+" ms");
                    count = 0;
                } else if(envelope.getType().equals("MESSAGE")) {
                    this.updateMessages(envelope.getFrom()+": "+envelope.getMsg());
                    count++;
                } else if(envelope.getType().equals("LEAVE")) {
                    this.removeFromClientList(envelope.getFrom());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void removeFromClientList(String from) {
        Platform.runLater(
                new Runnable() {
                    @Override
                    public void run() {
                        getController().getClientList().getItems().remove(from);
                    }
                }
        );
    }

    private void updateMessages(String msg) {
        Platform.runLater(
                new Runnable() {
                    @Override
                    public void run() {
                        getController().getMessages().appendText(msg+"\n");
                    }
                }
        );

    }

    private void updateSummary(String s) {
        Platform.runLater(
                new Runnable() {
                    @Override
                    public void run() {
                        getController().getSummary().appendText(s+"\n=====================\n");
                    }
                }
        );
    }

    private void updateClientList(String from) {
        Platform.runLater(
                new Runnable() {
                    @Override
                    public void run() {
                        getController().getClientList().getItems().add(from);
                    }
                }
        );
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    public void setOis(ObjectInputStream ois) {
        this.ois = ois;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public void setOos(ObjectOutputStream oos) {
        this.oos = oos;
    }
}
