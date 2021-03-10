import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    static int TCP_PORT = 3001;
    static int GATEWAY_PORT = 3000;

    public static void main(String[] args) throws IOException {
        ServerSource serverSource = new ServerSource();
        //client-gateway
        ClientGatewayTcp clientGatewayTcp = new ClientGatewayTcp(serverSource, GATEWAY_PORT, 3);
        //установить соединение с балансером и он даст свободный Server
        BalancerGatewayUdp balancer = new BalancerGatewayUdp(serverSource, TCP_PORT);

        //установить соединение с полученным портом
        //отправить сообщение на полученный порт
        //ждать ответа от любого сервера с сообщением
        //отправляю сообщение обратно клиенту

    }
}
