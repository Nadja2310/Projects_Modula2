package telran;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OurHashMapIntegerTest {
    @Test
    public void testSizePut_emptyObject_newElements() {
        OurMap<Integer, String> newMap = new OurHashMap<>();
        newMap.put(3, "f");
        newMap.put(2, "b");
        newMap.put(1, "c");
        assertEquals(3, newMap.size());
    }

    @Test
    public void testSizePut_emptyObject_noElements() {
        OurMap<Integer, String> newMap = new OurHashMap<>();
        assertEquals(0, newMap.size());
    }

    @Test
    public void testSizePut_NotEmptyObject_notExistKey() {
        OurMap<Integer, String> newMap = new OurHashMap<>();
        newMap.put(1, "a");
        newMap.put(2, "b");
        newMap.put(3, "c");
        assertEquals(3, newMap.size());
        newMap.put(4, "d");
        assertEquals(4, newMap.size());
    }

    @Test
    public void testSizePut_NotEmptyObject_existKey() {
        OurMap<Integer, String> newMap = new OurHashMap<>();
        newMap.put(1, "a");
        newMap.put(2, "b");
        newMap.put(3, "c");
        assertEquals(3, newMap.size());
        newMap.put(2, "d");
        assertEquals(3, newMap.size());
    }

    @Test
    public void testGetContains_NotEmptyObject_existKey() {
        OurMap<Integer, String> newMap = new OurHashMap<>();
        newMap.put(1, "a");
        newMap.put(2, "b");
        newMap.put(3, "c");
        assertEquals("b", newMap.get(2));
        assertEquals("a", newMap.get(1));
        assertEquals("c", newMap.get(3));
    }

    @Test
    public void testGetContains_NotEmptyObject_notExistKey() {
        OurMap<Integer, String> newMap = new OurHashMap<>();
        newMap.put(1, "a");
        newMap.put(2, "b");
        newMap.put(3, "c");
        assertThrows(NoSuchElementException.class, () ->newMap.get(5));
    }

    @Test
    public void testGetContains_emptyObject_notExistKey() {
        OurMap<Integer, String> newMap = new OurHashMap<>();
        assertThrows(NoSuchElementException.class, () ->newMap.get(5));
    }

    @Test
    public void testRemove_NotEmptyObject_existKey() {
        OurMap<Integer, String> newMap = new OurHashMap<>();
        newMap.put(1, "a");
        newMap.put(2, "b");
        newMap.put(3, "c");
        assertEquals(3, newMap.size());
        newMap.remove(2);
        assertEquals(2, newMap.size());
        assertThrows(NoSuchElementException.class, () ->newMap.get(2));
    }

    @Test
    public void testRemove_NotEmptyObject_notExistKey() {
        OurMap<Integer, String> newMap = new OurHashMap<>();
        newMap.put(1, "a");
        newMap.put(2, "b");
        newMap.put(3, "c");
        assertEquals(3, newMap.size());
        assertThrows(NoSuchElementException.class, () -> newMap.remove(5));
        assertEquals(3, newMap.size());
        assertThrows(NoSuchElementException.class, () -> newMap.get(5));
    }
}
