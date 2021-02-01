import org.omg.CosNaming.BindingIterator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.util.List;

public class IPrintStream implements IPrint {
    @Override
    public void writeFile(List<String> strings,String filename) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(filename);
        PrintStream printstream = new PrintStream(fos);
        for (String str:strings) {
            printstream.println(str);
        }
        printstream.close();
    }
}
