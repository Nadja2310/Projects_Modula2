import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Collector1Test {
    @Test
    public void testCollect_1() {
        Stream<Integer> numbers = Stream.of(5, 10, -3);

        List<Double> res = numbers.collect(new Collector1());
        System.out.println(res);
        //assertEquals(7, res, 0.00001);
    }
}