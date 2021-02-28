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

public class Collector1 implements Collector<Integer, List<Integer>, List<Double>> {

    @Override
    public Supplier<List<Integer>> supplier() {
        return () -> new ArrayList<>();
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
    public Function<List<Integer>, List<Double>> finisher() {

        return numbers -> {
            double max = Collections.max(numbers);
            double min = Collections.min(numbers);
            return numbers.stream()
                    .map(num ->((num - min) / (max - min)))
                    .collect(Collectors.toList());
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(Set.of(Collector.Characteristics.CONCURRENT));
    }
}
