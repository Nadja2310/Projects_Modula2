import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

public class IPrintWrite implements IPrint {

    @Override
    public void writeFile(List<String> strings, String filename) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(filename);
        PrintWriter printWriter = new PrintWriter(fos);
        for (String str : strings) {
            printWriter.println(str);
        }
        printWriter.close();
    }
}
