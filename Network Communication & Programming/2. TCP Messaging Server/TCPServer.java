import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class TCPServer {
    int port;
    ServerSocket ss;

    HashMap<String, ClientRequestHandler> clients;

    public TCPServer(int p) {
        this.port = p;
        clients = new HashMap<>();

        try {
            this.ss = new ServerSocket(this.port);

            while(true) {
                Socket s = this.ss.accept();
                String username = "User "+ (clients.size()+1);
                System.out.println("Connected "+ username);

                ClientRequestHandler crh = new ClientRequestHandler(s, clients, username);
                crh.start();

                this.clients.put(username, crh);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
