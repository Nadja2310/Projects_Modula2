package telran.string_operation.service.operation;

import org.springframework.stereotype.Service;
import telran.string_operation.service.operation.IStringOperation;

@Service
public class LowerCaseSO implements IStringOperation {
    @Override
    public String operate(String input) {
        return input.toLowerCase();
    }

    @Override
    public String getName() {
        return "lower_case";
    }
}