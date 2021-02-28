import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CollectorSgrtTest {

    @Test
    public void testCollectSgrt_1() {
        Stream<Integer> numbers = Stream.of(5, 10, -3);

        long res = numbers.collect(new CollectorSgrt());
        System.out.println(res);
        assertEquals(6, res, 0.00001);
    }
}