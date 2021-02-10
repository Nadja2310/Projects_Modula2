import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final static int NUMBER_THREAD=3;
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            //TODO create here several consumer threads and one supplier thread and start them.
            OneItemStringQueue queue = new OneItemStringQueue();
            Thread[] ThreadsSup = new Thread[NUMBER_THREAD];
            Thread[] ThreadsCons = new Thread[NUMBER_THREAD];
            for (int i = 0; i < NUMBER_THREAD; i++) {
                ThreadsSup[i] = new Thread(new MessageSupplier(queue, i, reader));
                ThreadsCons[i] = new Thread(new MessageConsumer(queue, i));
            }
            for (int i = 0; i < NUMBER_THREAD; i++) {
                //ThreadsSup[i].setDaemon(true);
                ThreadsSup[i].start();
                ThreadsCons[i].setDaemon(true);
                ThreadsCons[i].start();
            }
            for (int i = 0; i < NUMBER_THREAD; i++) {
                ThreadsSup[i].join();
            }
            System.out.println("exit main");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }
}
