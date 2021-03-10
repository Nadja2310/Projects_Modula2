import model.ServerInfo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientGatewayTcp implements Runnable{
    private ServerSource serverSource;

    private int tcpPort;

    private int threadPoolSize;

    private ServerSocket serverSocket;

    private ExecutorService executor;

    public ClientGatewayTcp(ServerSource serverSource, int tcpPort, int threadPoolSize) throws IOException {
        this.serverSource = serverSource;
        this.tcpPort = tcpPort;
        this.threadPoolSize = threadPoolSize;

        this.serverSocket = new ServerSocket(tcpPort);
        // Create threadPool
        this.executor= Executors.newFixedThreadPool(threadPoolSize);

    }


    @Override
    public void run() {

        while (true) {
            try {
                Socket socketToClient = serverSocket.accept();
                ServerInfo availableServer = serverSource.getAvailableServer();
                ServerTask serverTask = new ServerTask(socketToClient, availableServer);


                this.executor.execute(serverTask);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
