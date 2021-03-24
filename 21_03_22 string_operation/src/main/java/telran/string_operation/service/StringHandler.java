package telran.string_operation.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import telran.string_operation.service.operation.IStringOperation;
import telran.string_operation.OperationContext;
import java.io.PrintWriter;

@Component
public class StringHandler {
    private final OperationContext context;
    private PrintWriter writer;
    private final String separator;
    private final String wrong_format;
    private final String wrong_operation;

    // TODO take constants from the application props file. Other configure in the AppConfiguration
    public StringHandler(OperationContext context,
                         PrintWriter writer,
                         String separator,
                         String wrong_format,
                         String wrong_operation) {
        this.context = context;
        this.writer = writer;
        this.separator = separator;
        this.wrong_format = wrong_format;
        this.wrong_operation = wrong_operation;
    }

     @Async
    public void handleString(String line) {
        String res = handleRawString(line);
        writer.println(res);
        writer.flush();
        System.out.println("handleString " + res);
    }

    String handleRawString(String line) {
        String[] result = line.split(separator);

        if (result.length != 2)
            return line + separator + wrong_format;

        String stringToPerform = result[0];
        String operationName = result[1];

        IStringOperation stringOperation = context.getOperation(operationName);

        if (stringOperation == null)
            return line + separator + wrong_operation;

        return stringOperation.operate(stringToPerform);
    }
}
