import Operation.IStringOperation;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ConfigReader {
    private static final String DEFAULT_PATHS = "paths";
    private static final String SEPARATOR = ",";
    Properties properties;

    ConfigReader(String filePath) throws IOException {
        properties = new Properties();
        properties.load(new FileReader(filePath));
    }

    public List<String> getOperationPaths() {
        List<String> listOperation=new ArrayList<>();
        String pathsStr = properties.getProperty(DEFAULT_PATHS);
        String[] operationStr=pathsStr.split(SEPARATOR);

        if (operationStr.length==0)
                return null;

        listOperation.addAll(Arrays.asList(operationStr));
        return listOperation;
    }
}
