import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

public class ListPredicateMain {
    public static void main(String[] args) {
        ListPredicates listPredicates = new ListPredicates();
        IntPredicate x1 = (x -> x % 2 == 0);
        IntPredicate y1 = (y -> y % 3 == 0);
        IntPredicate z1 = (z -> z < 20);
        IntPredicate k1 = (k -> k > 10);
        List<IntPredicate> list = Arrays.asList(x1, y1, z1, k1);
        System.out.println(listPredicates.intersect(list).test(12));
        System.out.println(listPredicates.intersect(list).test(14));


    }
}
//f(x)=x*2
//g(x)=x+3
//f.compose(g)
//f(g(x))=(x+3)*2=2x+6
