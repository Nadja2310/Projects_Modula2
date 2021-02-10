import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MessageSupplier implements Runnable {

    OneItemStringQueue queue;
    int number;
    BufferedReader reader;

    public MessageSupplier(OneItemStringQueue queue, int number, BufferedReader reader) {
        this.queue = queue;
        this.number = number;
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            readFromConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromConsole() throws IOException {
        String line;
        while ((line = reader.readLine()) != null && !line.equals("exit")) {
            System.out.println("consumer No:" + number);
            queue.addFirst(line);
        }
        System.out.println("Exiting consumer No:" + number);
    }
}
