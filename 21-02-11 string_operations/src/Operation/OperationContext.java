package Operation;

import java.util.HashMap;
import java.util.Map;

public class OperationContext {
    private Map<String, IStringOperation> operationByName;

    {
        IStringOperation upperCase = new UpperCaseSO();

        operationByName = new HashMap<>();
        operationByName.put(upperCase.getName(), upperCase);

        IStringOperation lowerCase = new LowerCaseSO();
        operationByName.put(lowerCase.getName(), lowerCase);
    }

    public IStringOperation getOperation(String name) {
        return operationByName.get(name);
    }
}
