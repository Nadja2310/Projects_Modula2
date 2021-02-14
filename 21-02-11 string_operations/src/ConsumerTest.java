import Operation.IStringOperation;
import Operation.OperationContext;
import Operation.UpperCaseSO;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ConsumerTest {
    PrintWriter printWriter;
    BlockingQueue<String> queue;
    OperationContext context;
    IStringOperation operation;
    Consumer consumer;

    @Before
    public void init() {
        printWriter = mock(PrintWriter.class);
        queue=mock(LinkedBlockingQueue.class);
        context=mock(OperationContext.class);
        operation=mock(IStringOperation.class);

        consumer=new Consumer(queue,printWriter,context);
        consumer=spy(consumer);
    }

    @Test
    public void test_handleRawString_regular(){
        String input="CAR#lower_case";
        when(context.getOperation("lower_case")).thenReturn(operation);
        when(consumer.handleRawString(input)).thenReturn("car");
    }

    @Test
    public void test_handleRawString_wrongFormat()  {
        String input="cat#ower_case#cat";
        when(consumer.handleRawString(input)).thenReturn("cat#ower_case#cat#wrong format");
    }

    @Test
    public void test_handleRawString_wrongOperation_inputError()  {
        String input="world#ipper_case";
        when(consumer.handleRawString(input)).thenReturn("world#ipper_case#wrong operation");
    }
    @Test
    public void test_handleRawString_wrongOperation_noOperation()  {
        String input="world#";
        when(consumer.handleRawString(input)).thenReturn("world#ipper_case#wrong operation");
    }
}