import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerTask implements Runnable {
    private final Socket socket;

    public ServerTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        PrintStream socketOutput;
        BufferedReader socketInput;

        try {
            socketOutput = new PrintStream(socket.getOutputStream());
            socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line;
            while ((line = socketInput.readLine()) != null) {
                String response = "Handle by server " + line;
                socketOutput.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socketInput.close();
            socketOutput.close();
        }

    }
}
