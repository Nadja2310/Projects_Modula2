package task1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolvTest {

    Solv tast1 = new Solv();
    List<Integer> list = new ArrayList<>();
    HashSet<Integer> hashSet = new HashSet<>();

    @Test
    public void Test1_EmptyList() {

        hashSet = tast1.setlist(list);
        assertEquals(0, hashSet.size());

    }

    @Test
    public void Test1() {

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        hashSet = tast1.setlist(list);
        assertEquals(3, hashSet.size());
        for (int i = 1; i < 4; i++) {
            assertTrue(hashSet.contains(i));
        }

    }

}