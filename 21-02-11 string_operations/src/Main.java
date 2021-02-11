import Operation.OperationContext;

import java.io.*;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        // TODO. Introduce here the following objects: BufferedReader (read from file),
        //  PrintWriter (write to file),
        // TODO LinkedBlockingQueue (to pass between supplier and consumer), OperationContext,
        //  3 Consumers and 1 Supplier.
        // TODO And run the threads.
        String filename = "input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        PrintWriter printWriter = new PrintWriter(new FileOutputStream("output.txt"));
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        Thread supplierThread = new Thread(new Supplier(bufferedReader, queue));
        supplierThread.start();

        OperationContext context = new OperationContext();

        Thread consumerThread1 = new Thread(new Consumer(queue, printWriter, context));
        Thread consumerThread2 = new Thread(new Consumer(queue, printWriter, context));
        Thread consumerThread3 = new Thread(new Consumer(queue, printWriter, context));
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();
        supplierThread.join();

        consumerThread1.join();
        consumerThread2.join();
        consumerThread3.join();
        System.out.println("end");
        printWriter.close();
    }
}
