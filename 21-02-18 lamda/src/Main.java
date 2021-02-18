import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
//1
        List<String> inputList = Arrays.asList("cat", "dog", "fisch", "cat", "dog", "cat");

        Function<List<String>, List<String>> list1 = (list) -> {
            return new ArrayList<>(new HashSet<>(list));
        };
        System.out.println(list1.apply(inputList));

        //2
        final int a = 10;
        final int b = 16;
        final int c = 3;
        Function<Integer, Integer> f = (x) -> a * x * x + b * x + c;
        System.out.println(f.apply(5));

    }
}
