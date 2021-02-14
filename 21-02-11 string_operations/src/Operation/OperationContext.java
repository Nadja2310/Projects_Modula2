package Operation;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationContext {
    private Map<String, IStringOperation> operationByName;

   /* {
        IStringOperation upperCase = new UpperCaseSO();


        operationByName.put(upperCase.getName(), upperCase);

        IStringOperation lowerCase = new LowerCaseSO();
        operationByName.put(lowerCase.getName(), lowerCase);
    }*/

    public OperationContext(List<String> operationPaths) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // TODO compose 'operationByName' by the paths to the necessary operations
        operationByName = new HashMap<>();
        for (String str : operationPaths) {
            IStringOperation operation = (IStringOperation) Class
                    .forName(str)
                    .getConstructor()
                    .newInstance();
            operationByName.put(operation.getName(), operation);
        }
    }

    public IStringOperation getOperation(String name) {
        return operationByName.get(name);
    }
}
