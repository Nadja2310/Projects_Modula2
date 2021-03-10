import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class BalancerGatewayUdp implements Runnable {

    private ServerSource serverSource;

    private int udpPort;
    private final int PACKET_SIZE = 1024;

    public BalancerGatewayUdp(ServerSource serverSource, int udpPort) {
        this.serverSource = serverSource;
        this.udpPort = udpPort;
    }

    @Override
    public void run() {
        DatagramSocket serverUdpSocket = null;
        try {
            serverUdpSocket = new DatagramSocket(udpPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        byte[] dataIn = new byte[PACKET_SIZE];
        DatagramPacket packetIn = new DatagramPacket(dataIn, PACKET_SIZE);

        while (true) {
            try {
                serverUdpSocket.receive(packetIn);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String line = new String(dataIn, 0, packetIn.getLength());
            Map<String, Integer> updates = getPortServer(line);
            serverSource.updateOptimalServers(updates);
        }
    }

    private Map<String, Integer> getPortServer(String packet) {
        Map<String, Integer> optimalServers = new HashMap<>();
        String[] portServerArray = packet.split(",");
        if (portServerArray != null) {
            String server = portServerArray[0];
            int port = Integer.parseInt(portServerArray[1]);
            optimalServers.put(server, port);
            System.out.println("Balancer " + server + " port " + port);
        }
        return optimalServers;
    }

}
