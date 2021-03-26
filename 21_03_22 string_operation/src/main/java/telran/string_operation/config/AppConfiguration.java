package telran.string_operation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import telran.string_operation.OperationContext;
import telran.string_operation.service.operation.IStringOperation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.Executor;

@EnableAsync
@Configuration
public class AppConfiguration {

    @Bean
    public OperationContext context(List<IStringOperation> operation) {

        return new OperationContext(operation);
    }

    @Bean
    public PrintWriter printWriter(@Value("${telran.string_operation.output.file.path}")
                                           String output) throws FileNotFoundException {
        return new PrintWriter(new FileOutputStream(output));
    }

    @Bean
    public Executor taskExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(5);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(3600); // wait an hour if necessary
        executor.setThreadNamePrefix("StringOperations-");
        executor.initialize();
        return executor; }
}
