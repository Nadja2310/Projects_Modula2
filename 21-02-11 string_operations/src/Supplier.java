import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class Supplier implements Runnable {
    private final BufferedReader br;
    private final BlockingQueue<String> queue;

    public Supplier(BufferedReader br, BlockingQueue<String> queue) {
        this.br = br;
        this.queue = queue;
    }

    @Override
    public void run() {
          try {
            String line;
            while ((line = br.readLine()) != null) {
                queue.put(line);
               // System.out.println("queue " + line);
                exit();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void exit() throws InterruptedException {
        queue.put("exit");
        queue.put("exit");
        queue.put("exit");
    }
}
