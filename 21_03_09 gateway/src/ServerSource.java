import model.ServerInfo;

import java.util.HashMap;
import java.util.Map;

public class ServerSource {

    Map<String, Integer> optimalServers = new HashMap<>();

    // serv1.put("Server1", 3000);
//        serv2.put("Server2", 4200);
//        serv3.put("Server3", 8080);
    public synchronized Map<String, Integer> getOptimalServers() {
        return optimalServers;
    }

    public synchronized void updateOptimalServers(Map<String, Integer> updates) {
        optimalServers.putAll(updates);
    }

    public ServerInfo getAvailableServer() {
        Map.Entry<String, Integer> firstEntry = optimalServers.entrySet().iterator().next();
        return new ServerInfo(firstEntry.getKey(), firstEntry.getValue());
    }
}
