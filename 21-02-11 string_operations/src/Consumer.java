import Operation.OperationContext;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
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
        for (String line : queue) {
            String res = handleRawString(line);
            writer.println(res);
        }
    }

    String handleRawString(String line) {
        //TODO complete
        //TODO if the line is of a wrong format then return it with the postfix '#wrong format' back. 'hello world'-> 'hello world#wrong format'
        //TODO or 'hello world#upper_case#param'-> 'hello world#upper_case#param#wrong format'

        //TODO Get the operation by its name.

        //TODO if the format seems to be correct, but the operation is not found then write to the file the line with the
        //TODO postfix ''. E.g. "hello world#opper_case" -> "hello world#opper_case#wrong operation"
        int sizeStr = line.indexOf("#");

        if (sizeStr == -1 || line.lastIndexOf("#") != sizeStr)//indexOf("#",sizeStr+1)>0)
            return line + "#wrong format";
        String nameOperation = line.substring(sizeStr + 1, line.length());

        if (context.getOperation(nameOperation) != null) {
            String str = line.substring(0,sizeStr);
            return context.getOperation(nameOperation).operate(str);
        } else
            return line + "#wrong operation";
    }
}
