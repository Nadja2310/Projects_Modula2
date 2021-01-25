package telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class OurHashMapTest extends OurMapTest{

    @BeforeEach
        public void init(){
        map = new OurHashMap<>();
        intMap=new OurHashMap<>();
    }

    @Test
    void testPut_resize() {
        map = new OurHashMap<>(0.5);
        Auto opel = new Auto("grey", "Opel");
        Auto mazda = new Auto("red", "Mazda");
        Auto bmw = new Auto("black", "BMW");
        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN4528", opel);
        map.put("WIN74528", opel);
        map.put("WIN56828", mazda);
        map.put("WIN56628", mazda);
        map.put("WIN56298", mazda);
        map.put("WIN8988", bmw);
        map.put("WIN8989", bmw);
        map.put("WIN5628", audi);
        map.put("WIN56256", audi2);
        assertEquals(map.get("WIN56256"), audi2);
        assertEquals(map.size(), 9);
    }

    @Test
    public void testKeyIterator_emptyList() {
        Iterator<String> iterator = map.keyIterator();

        assertFalse(iterator.hasNext());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testKeyIterator_oneElement() {

        Auto opel = new Auto("grey", "Opel");
        map.put("WIN4528", opel);

        Iterator<String> iterator = map.keyIterator();

        int i = 0;
        while (iterator.hasNext()) {
            String key=iterator.next();
            System.out.println(key);
            assertEquals("WIN4528", key);
        }

        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testKeyIterator_severalElements() {
        Auto opel = new Auto("grey", "Opel");
        Auto mazda = new Auto("red", "Mazda");
        Auto bmw = new Auto("black", "BMW");
        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN4528", opel);
        map.put("WIN74528", opel);
        map.put("WIN56828", mazda);
        map.put("WIN56628", mazda);
        map.put("WIN56298", mazda);
        map.put("WIN8988", bmw);
        map.put("WIN8989", bmw);
        map.put("WIN5628", audi);
        map.put("WIN56256", audi2);

        Iterator<String> iterator = map.keyIterator();

        int i = 0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            i++;
        }

        assertEquals(i, map.size());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void test_keyIterator() {
        for (int i = 0; i < 5; i++) {
            intMap.put(i, "aaa");
            intMap.put(i * 2, "bbb");
        }
        Iterator<Integer> iterator = intMap.keyIterator();
        int[] exp = {0, 1, 2, 3, 4, 6, 8};
        int i = 0;
        while (iterator.hasNext()) {
            iterator.next();
            i++;
//            assertEquals(exp[i++], iterator.next());
        }

        assertEquals(7, i);
    }
}
