package model;

public class ServerInfo {
    private String hostname;

    private int port;

    public ServerInfo(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }
}
