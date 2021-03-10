import model.ServerInfo;

import java.util.Map;

public class ServerSource {

    ServerInfo optimalServer;

//       serv1.put("Server1", 3000);
//       serv2.put("Server2", 4200);
//       serv3.put("Server3", 8080);
    public synchronized ServerInfo getOptimalServer() {
        return optimalServer;
    }

    public synchronized void updateOptimalServer(ServerInfo updates) {
        optimalServer = updates;
    }
}
