package telran;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class OurHashMapTest {
    OurHashMap<String, Auto> map = new OurHashMap<>();


    @Test
    void testPut_resize() {
        OurHashMap<String, Auto> map = new OurHashMap<>(0.5);
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
    void changeTheValueOofAnExistingElement() {

        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN5628", audi);
        map.put("WIN5628", audi2);
        assertEquals(map.get("WIN5628"), audi2);
        assertTrue(map.get("WIN5628") != audi);
    }

    @Test
    void testRemove_twoObjectInCells() {
        OurHashMap<String, Auto> map = new OurHashMap<>();
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
        assertEquals(map.get("WIN74528"), bmw);
        assertEquals(map.size(), 8);
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
        assertThrows(NoSuchElementException.class, () -> map.get("WIN8988"));
        assertEquals(map.size(), 8);
    }
}