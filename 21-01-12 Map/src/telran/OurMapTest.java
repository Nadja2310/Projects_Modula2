package telran;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public abstract class OurMapTest {
    OurMap<String,Auto> map;
    OurMap<Integer,String> intMap;


    @Test
    void changeTheValueOofAnExistingElement() {

        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN5628", audi);
        map.put("WIN5628", audi2);
        assertEquals(map.get("WIN5628"), audi2);
        assertTrue(map.get("WIN5628") != audi);
        assertEquals(map.size(), 1);
    }

    @Test
    void containsKey_EmptyMap() {
        assertFalse(map.containsKey("WIN5620"));

        assertEquals(0,map.size());
    }

    @Test
    void containsKey_ServerElement() {

        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN5628", audi);
        map.put("WIN5628", audi2);
        assertTrue(map.containsKey("WIN5628"));

        assertFalse(map.containsKey("WIN5620"));
    }

    @Test
    void testRemove_twoObjectInCells_bottom() {
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
        assertEquals(map.remove("WIN8989"), bmw);
        assertEquals(map.get("WIN74528"), opel);
        assertEquals(map.size(), 8);
        String[] autoWin={"WIN4528","WIN56828","WIN74528","WIN56628","WIN56298","WIN8988","WIN5628","WIN56256"};
        checkAllElements(map,autoWin);
    }

    @Test
    void testRemove_OneElement(){
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

        assertEquals(map.remove("WIN8988"), bmw);
        assertNull(map.get("WIN8988"));
        assertEquals(map.size(), 8);
        String[] autoWin = {"WIN4528", "WIN56828", "WIN74528", "WIN56628", "WIN56298", "WIN8989", "WIN5628", "WIN56256"};
        checkAllElements(map, autoWin);
    }
    @Test
    void testRemove_twoObjectInCells_UpElement() {

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
    void put_changeElement() {

        Auto opel = new Auto("grey", "Opel");
        Auto mazda = new Auto("red", "Mazda");
        Auto bmw = new Auto("black", "BMW");
        Auto bmw1 = new Auto("pink", "BMW");
        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN4528", opel);
        map.put("WIN8988", bmw);
        map.put("WIN8988", bmw1);
        assertEquals(map.get("WIN8988"), bmw1);
        assertTrue(map.get("WIN8988") != bmw);


        map.put("WIN74528", opel);
        map.put("WIN56828", mazda);
        map.put("WIN56628", mazda);
        map.put("WIN56298", mazda);

        map.put("WIN5628", audi);
        map.put("WIN5628", audi2);
        assertEquals(map.get("WIN5628"), audi2);
        assertTrue(map.get("WIN5628") != audi);
        assertEquals(map.size(), 7);

        String[] autoWin={"WIN4528","WIN56828","WIN74528","WIN56628","WIN56298","WIN8988","WIN5628"};
        checkAllElements(map,autoWin);
    }

    void checkAllElements(OurMap<String, Auto> mapCheck,String[] arrayStr){
        for (String elm:arrayStr) {
            // System.out.println(elm);
            assertTrue(mapCheck.get(elm)!=null);
        }
    }


    @Test
    public void testSizePut_emptyObject_newElements() {
        intMap.put(3, "f");
        intMap.put(2, "b");
        intMap.put(1, "c");
        assertEquals(3, intMap.size());
    }

    @Test
    public void testSizePut_emptyObject_noElements() {
        assertEquals(0, intMap.size());
    }

    @Test
    public void testSizePut_NotEmptyObject_notExistKey() {
        intMap.put(1, "a");
        intMap.put(2, "b");
        intMap.put(3, "c");
        assertEquals(3, intMap.size());
        intMap.put(4, "d");
        assertEquals(4, intMap.size());
    }

    @Test
    public void testSizePut_NotEmptyObject_existKey() {
        intMap.put(1, "a");
        intMap.put(2, "b");
        intMap.put(3, "c");
        assertEquals(3, intMap.size());
        intMap.put(2, "d");
        assertEquals(3, intMap.size());
    }

    @Test
    public void testGetContains_NotEmptyObject_existKey() {
        intMap.put(1, "a");
        intMap.put(2, "b");
        intMap.put(3, "c");
        assertEquals("b", intMap.get(2));
        assertEquals("a", intMap.get(1));
        assertEquals("c", intMap.get(3));
    }

    @Test
    public void testGetContains_NotEmptyObject_notExistKey() {
        intMap.put(1, "a");
        intMap.put(2, "b");
        intMap.put(3, "c");
        assertNull(intMap.get(5));
    }

    @Test
    public void testGetContains_emptyObject_notExistKey() {
        assertNull(intMap.remove(5));
    }

    @Test
    public void testRemove_NotEmptyObject_existKey() {
        intMap.put(1, "a");
        intMap.put(2, "b");
        intMap.put(3, "c");
        assertEquals(3, intMap.size());
        intMap.remove(2);
        assertEquals(2, intMap.size());
        assertNull(intMap.get(2));
    }

    @Test
    public void testRemove_NotEmptyObject_notExistKey() {
        intMap.put(1, "a");
        intMap.put(2, "b");
        intMap.put(3, "c");
        assertEquals(3, intMap.size());
        assertNull(intMap.remove(5));
        assertEquals(3, intMap.size());
        assertNull(intMap.get(5));
    }

}