import networking.Envelope;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class ClientRequestHandler extends Thread {
    Socket socket;
    ObjectOutputStream oos;
    ObjectInputStream ois;

    HashMap<String, ClientRequestHandler> clientHandlers;

    String username;

    public ClientRequestHandler(Socket s, HashMap<String, ClientRequestHandler> clients, String name)  {
        this.socket = s;
        this.clientHandlers = clients;
        this.username = name;

        try {
            this.oos = new ObjectOutputStream(this.socket.getOutputStream());
            this.ois = new ObjectInputStream(this.socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Envelope envelope = new Envelope();
        envelope.setType("NAME");
        envelope.setMsg(this.username);


        try {
            this.getOos().writeObject(envelope);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(String toUser: clientHandlers.keySet()) {
            if(!toUser.equals(this.username)) {
                try {
                    Envelope en1 = new Envelope();
                    en1.setType("JOIN");
                    en1.setFrom(this.username);
                    clientHandlers.get(toUser).getOos().writeObject(en1);

                    Envelope en2 = new Envelope();
                    en2.setType("JOIN");
                    en2.setFrom(toUser);
                    this.getOos().writeObject(en2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        while (true) {
            try {
                Envelope en = (Envelope) this.ois.readObject();
                this.send(en);

            } catch (IOException e) {
                System.out.println("Client disconnected");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public void send(Envelope en) throws IOException {
        if(en.getType().equals("LEAVE")) {
            for(String toUser: this.clientHandlers.keySet()) {
                this.clientHandlers.get(toUser).getOos().writeObject(en);
            }

        } else {
            this.clientHandlers.get(en.getTo()).getOos().writeObject(en);
        }

    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public void setOos(ObjectOutputStream oos) {
        this.oos = oos;
    }
}
