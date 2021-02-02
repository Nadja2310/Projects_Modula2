import java.io.FileNotFoundException;
import java.util.List;

public interface IPrint {
    void writeFile(List<String> strings, String filename) throws FileNotFoundException;
}
