package telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OurTreeMapTest extends OurMapTest{

    @BeforeEach
    public void init(){
        map = new OurTreeMap<>();
        intMap=new OurTreeMap<>();
    }
    @Test
    void testRemove_twoObjectInCells_UpElement2() {

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
        assertEquals(opel,map.remove("WIN74528"));
//        assertEquals(map.get("WIN74528"), bmw);
        assertEquals(8,map.size());

        String[] autoWin={"WIN4528","WIN56828","WIN56628","WIN56298","WIN8988","WIN8989","WIN5628","WIN56256"};
        checkAllElements(map,autoWin);
    }
    @Test
    public void testRemoveAdd_severalElements_removeRoot() {
        intMap.put(1, "a");
        intMap.put(2, "b");
        assertEquals(2, intMap.size());
        assertEquals("a", intMap.remove(1));
        assertEquals(1, intMap.size());
        assertEquals("b", intMap.get(2));
    }

    @Test
    public void testRemoveAdd_severalElements_removeRight() {
        intMap.put(1, "a");
        intMap.put(2, "b");
        assertEquals(2, intMap.size());
        assertEquals("b", intMap.remove(2));
        assertEquals(1, intMap.size());
        assertEquals("a", intMap.get(1));
    }

    @Test
    public void testKeyIterator_severalElements_increasing() {
        intMap.put(1, "a");
        intMap.put(-10, "b");
        intMap.put(5, "b");
        intMap.put(3, "b");
        intMap.put(-5, "b");
        intMap.put(2, "b");

        List<Integer> expected = Arrays.asList(-10, -5, 1, 2, 3, 5);

        List<Integer> actual = new ArrayList<>();

        Iterator<Integer> keyIterator = intMap.keyIterator();
        while (keyIterator.hasNext())
            actual.add(keyIterator.next());

        assertEquals(expected, actual);
    }

    @Test
    public void testKeyIterator_severalElements_rootToTheLeft() {
        intMap.put(-10, "b");
        intMap.put(-5, "b");
        intMap.put(1, "a");
        intMap.put(2, "b");
        intMap.put(3, "b");
        intMap.put(5, "b");

        List<Integer> expected = Arrays.asList(-10, -5, 1, 2, 3, 5);

        List<Integer> actual = new ArrayList<>();

        Iterator<Integer> keyIterator = intMap.keyIterator();
        while (keyIterator.hasNext())
            actual.add(keyIterator.next());

        assertEquals(expected, actual);
    }

    //TODO implement and write tests for value iterator
    @Test
    public void testValueIterator_severalElements_rootToTheLeft() {
        intMap.put(-10, "-10");
        intMap.put(-5, "-5");
        intMap.put(1, "1");
        intMap.put(2, "2");
        intMap.put(3, "3");
        intMap.put(5, "5");

        List<String> expected = Arrays.asList("-10", "-5", "1","2","3","5");

        List<String> actual = new ArrayList<>();

        Iterator<String> valueIterator = intMap.valueIterator();
        while (valueIterator.hasNext())
            actual.add(valueIterator.next());

        assertEquals(expected, actual);
    }
    @Test
    public void testValueIterator_severalElements_increasing() {
        intMap.put(1, "1");
        intMap.put(-10, "-10");
        intMap.put(5, "5");
        intMap.put(3, "3");
        intMap.put(-5, "-5");
        intMap.put(2, "2");

        List<String> expected = Arrays.asList("-10", "-5", "1", "2", "3", "5");

        List<String> actual = new ArrayList<>();

        Iterator<String> valueIterator = intMap.valueIterator();
        while (valueIterator.hasNext())
            actual.add(valueIterator.next());

        assertEquals(expected, actual);
    }
}