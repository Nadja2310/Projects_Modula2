import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListPredicates {
    public IntPredicate intersect(List<IntPredicate> predicates) {
        int a = 10;
        IntPredicate res = predicates.get(0);
        for (IntPredicate elt : predicates) {
            res = res.and(elt);
        }
        return res;
    }
}


