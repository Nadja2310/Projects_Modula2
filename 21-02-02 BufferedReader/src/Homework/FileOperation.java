package Homework;

import java.io.IOException;
import java.util.List;

public interface FileOperation {
    public List<String> inputText() throws IOException;
    public void writeToFile(List<String> text,String filename) throws IOException;
}
