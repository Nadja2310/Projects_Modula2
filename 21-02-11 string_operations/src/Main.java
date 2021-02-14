import Operation.OperationContext;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;



//video 12-02
public class Main {

    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";
    private static final String CONFIG = "config.props";

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT));
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(OUTPUT));
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        ConfigReader configReader=new ConfigReader(CONFIG);
        Thread supplierThread = new Thread(new Supplier(bufferedReader, queue));
        supplierThread.start();

        OperationContext context = new OperationContext(configReader.getOperationPaths());

        Thread consumerThread1 = new Thread(new Consumer(queue, printWriter, context));
        Thread consumerThread2 = new Thread(new Consumer(queue, printWriter, context));
        Thread consumerThread3 = new Thread(new Consumer(queue, printWriter, context));
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();

        consumerThread1.join();
        consumerThread2.join();
        consumerThread3.join();

   //     supplierThread.join();

        printWriter.close();
    }
}
