package telran.string_operation.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import telran.string_operation.OperationContext;
import telran.string_operation.service.StringHandler;
import telran.string_operation.service.operation.IStringOperation;
import telran.string_operation.service.operation.LowerCaseSO;
import telran.string_operation.service.operation.UpperCaseSO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class AppConfiguration {

    @Bean
    @Qualifier("operationContext")
    public LowerCaseSO lowerCase() {
        return new LowerCaseSO();
    }

    @Bean
    @Qualifier("operationContext")
    public UpperCaseSO upperCase() {
        return new UpperCaseSO();
    }

    @Bean
    @Qualifier("context")
    public OperationContext context(@Qualifier("operationContext") List<IStringOperation> operationContext) {
        return new OperationContext(operationContext);
    }

    @Bean
    @Qualifier("printWriter")
    public PrintWriter printWriter(@Value("${telran.string_operation.output.file.path}")
                                           String output) throws FileNotFoundException {
        return new PrintWriter(new FileOutputStream(output));
    }

    @Bean
    @Qualifier("separator")
    public String separator(@Value("${telran.spring_operation.separation}")
                                    String sep) {
        return sep;
    }

    @Bean
    @Qualifier("wrong_format")
    public String wrong_format(@Value("${telran.spring_operation.wrong_format}")
                                       String wrong_form) {
        return wrong_form;
    }

    @Bean
    @Qualifier("wrong_operation")
    public String wrong_operation(@Value("${telran.spring_operation.wrong_operation}")
                                          String wrong_oper) {
        return wrong_oper;
    }

    @Configuration
    @EnableAsync
    class AsyncConfig implements AsyncConfigurer {
        @Bean()
        public Executor getAsyncExecutor() {
            return Executors.newFixedThreadPool(3);
        }
    }

   /* @Bean
    public StringHandler handler(@Qualifier("context") OperationContext context,
                                 @Qualifier("printWriter") PrintWriter printWriter,
                                 @Qualifier("separator") String separator,
                                 @Qualifier("wrong_format") String wrong_format,
                                 @Qualifier("wrong_operation") String wrong_operation) {
        return new StringHandler(context, printWriter, separator, wrong_format, wrong_operation);
    }*/
}
