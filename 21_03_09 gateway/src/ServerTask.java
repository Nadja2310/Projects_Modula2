import model.ServerInfo;

import java.io.IOException;
import java.net.Socket;

public class ServerTask implements Runnable{

    private Socket socketToServer;

    private Socket socketToClient;

    private ServerInfo serverInfo;

    public ServerTask(Socket socketToServer, ServerInfo serverInfo) throws IOException {
      //  this.socketToServer = socketToServer;
        this.serverInfo = serverInfo;
        this.socketToServer =  new Socket(serverInfo.getHostname(), serverInfo.getPort());
    }

    @Override
    public void run() {

    }
}
