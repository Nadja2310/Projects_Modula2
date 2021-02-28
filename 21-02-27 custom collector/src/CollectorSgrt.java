import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorSgrt implements Collector<Integer, List<Integer>, Long> {


    @Override
    public Supplier<List<Integer>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Integer>, Integer> accumulator() {
        return (temporaryList, number) -> temporaryList.add(number);
    }

    @Override
    public BinaryOperator<List<Integer>> combiner() {
        return (currentRes, currentList) -> {
            currentRes.addAll(currentList);
            return currentRes;
        };
    }

    @Override
    public Function<List<Integer>, Long> finisher() {
        return numbers -> {
            long sum = numbers.stream()
                    .map(num -> num * num)
                    .map(numberInt -> numberInt.longValue())
                    .reduce(0L, (currentRes, currentNum) -> currentRes + currentNum);
            return (long) Math.sqrt(sum / numbers.size());
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(Set.of(Collector.Characteristics.CONCURRENT));
    }
}
