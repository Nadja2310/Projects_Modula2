import Operation.IStringOperation;
import Operation.OperationContext;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private static final String SEPARATOR = "#";
    private static final String WRONG_FORMAT = "wrong format";
    private static final String WRONG_OPERATION = "wrong operation";

    private final BlockingQueue<String> queue;
    private final PrintWriter writer;
    private final OperationContext context;

    public Consumer(BlockingQueue<String> queue, PrintWriter writer, OperationContext context) {
        this.queue = queue;
        this.writer = writer;
        this.context = context;
    }

    @Override
    public void run() {

        try {
            while (true) {
               // System.out.println(queue.size());
                String line = queue.take();
                if (line.equals("exit"))
                    return ;

                String resLine = handleRawString(line);
                writer.println(resLine);
                writer.flush();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected String handleRawString(String line) {
        //TODO complete
        //TODO if the line is of a wrong format then return it with the postfix '#wrong format' back. 'hello world'-> 'hello world#wrong format'
        //TODO or 'hello world#upper_case#param'-> 'hello world#upper_case#param#wrong format'

        //TODO Get the operation by its name.

        //TODO if the format seems to be correct, but the operation is not found then write to the file the line with the
        //TODO postfix ''. E.g. "hello world#opper_case" -> "hello world#opper_case#wrong operation"
        String[] result = line.split(SEPARATOR);

        if (result.length != 2)
            return line + SEPARATOR + WRONG_FORMAT;

        String stringToPerform = result[0];
        String operationName = result[1];

        IStringOperation stringOperation = context.getOperation(operationName);

        if (stringOperation == null)
            return line + SEPARATOR + WRONG_OPERATION;

        return stringOperation.operate(stringToPerform);
    }
}

