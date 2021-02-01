import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class IPrintTester {
    private IPrint iprint;

     public IPrintTester(IPrint iprint) {
        this.iprint = iprint;
    }

    public void test(int time, List<String> strings,String filename) throws FileNotFoundException {

        long beforeConcatenation = System.currentTimeMillis();
        iprint.writeFile(strings,filename);
        long timeConcatenated = System.currentTimeMillis() - beforeConcatenation;

        System.out.println(timeConcatenated);
    }
}
