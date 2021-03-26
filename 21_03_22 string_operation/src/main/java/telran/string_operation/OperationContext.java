package telran.string_operation;

import org.springframework.stereotype.Component;
import telran.string_operation.service.operation.IStringOperation;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class OperationContext {

    private final Map<String, IStringOperation> operationByName;

    public OperationContext(List<IStringOperation> operations) {
        operationByName = operations.stream()
                .collect(toMap(IStringOperation::getName,operation -> operation));
    }

    public IStringOperation getOperation(String name) {
        return operationByName.get(name);
    }
}