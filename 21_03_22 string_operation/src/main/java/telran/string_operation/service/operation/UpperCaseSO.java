package telran.string_operation.service.operation;

import org.springframework.stereotype.Service;
import telran.string_operation.service.operation.IStringOperation;

@Service
public class UpperCaseSO implements IStringOperation {
    @Override
    public String operate(String input) {
        return input.toUpperCase();
    }

    @Override
    public String getName() {
        return "upper_case";
    }
}
