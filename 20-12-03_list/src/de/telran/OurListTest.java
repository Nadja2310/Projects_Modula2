package de.telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public abstract class OurListTest {
    OurList<Integer> listInteger;
    OurList<String> list;

    @Test
    public void testSize_emptyList_zero() {
        assertEquals(0, list.size());
    }

    @Test
    public void testGet_emptyList_throwsIOOBE() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-10));
    }

    @Test
    public void testRemoveById_emptyList_throwsIOOBE() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(-10));
    }

    @Test
    public void testSet_emptyList_throwsIOOBE() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, "0"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(10, "0"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-10, "0"));
    }

    @Test
    public void testSizeAndAddLast_addSeveralElements_correctSize() {
        list.addLast("str1");
        list.addLast("str2");
        list.addLast("str3");
        assertEquals(3, list.size());
    }

    @Test
    public void testGetAndAddLast_addSeveralElements_correctOrderOfElements() {
        String[] str = new String[10];
        int j = 0;
        for (char i = 0; i < 10; i++) {
            list.addLast("str " + i);
            str[j] = "str " + i;
            j++;
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(str[i], list.get(i));
        }
    }

    @Test
    public void testRemoveById_addSeveralElementsAndRemoveLast_correct() {
        createArrayList(10);

        assertEquals("symbol D", list.removeById(3));
        assertEquals(9, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(10, "str"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(10));
    }

    @Test
    public void testRemoveById_addCapacityNumberElementsAndRemoveLast_correct() {

        createArrayList(16);

        assertEquals("symbol P", list.removeById(15));
        assertEquals(15, list.size());

     /*   assertThrows(IndexOutOfBoundsException.class, () -> list.get(15));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(15, "111"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(15));*/

    }

    @Test
    public void testRemoveById_addCapacityNumberElementsAndRemoveFirst_correct() {

        for (int i = 0; i < 16; i++) {
            list.addLast("symbol " + i);
        }

        assertEquals("symbol 0", list.removeById(0));
        assertEquals(15, list.size());
        assertEquals("symbol 15", list.get(14));

        for (int i = 1; i < list.size(); i++) {
            assertEquals("symbol " + (i + 1), list.get(i));
        }

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(15));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(15, "111"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(15));
    }

    @Test
    public void testRemoveById_addCapacityNumberElementsAndRemoveIntermediate_correct() {

        for (int i = 0; i < 16; i++) {
            list.addLast("symbol " + i);
        }

        assertEquals("symbol 5", list.removeById(5));
        assertEquals(15, list.size());

        for (int i = 0; i < 5; i++) {
            assertEquals("symbol " + i, list.get(i));
        }

        for (int i = 5; i < list.size(); i++) {
            assertEquals("symbol " + (i + 1), list.get(i));
        }

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(17));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(17, "111"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(17));
    }

    @Test
    public void testAddLast_addInitialCapacityPlusOneElements_correctSizAndCapacity() {
        for (int i = 0; i < 17; i++) {
            list.addLast("symbol " + i);
        }

        assertEquals(17, list.size());
        //assertEquals(32, list.source.length);
    }

    @Test
    public void testSet_toFirstIndex() {

        createArrayList(5);
        list.set(0, "100098");

        assertEquals("100098", list.get(0));
    }

    @Test
    public void testSet_toLastIndex() {

        createArrayList(5);
        list.set(list.size() - 1, "404");

        assertEquals("404", list.get(list.size() - 1));
    }

    @Test
    public void set_To_Index_Between_First_And_Last() {

        int numberOfElements = 20;
        createArrayList(numberOfElements);

        list.set(17, "30998");

        assertEquals("30998", list.get(17));
    }

    @Test
    public void testClear_emptyList() {
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testClear_nonEmptyList() {
        createArrayList(20);

        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testUniversal_addSeveralElementsThenSetThenRemove_etc() {
        createArrayList(4);//{symbol A,symbol B,symbol C,symbol D}

        list.removeById(2);//{symbol A,symbol B,symbol D}
        list.set(1, "symbol 555");//{symbol A,symbol 555,symbol D}

        list.addLast("symbol SS");
        list.addLast("symbol KK");

        list.removeById(2);
        list.removeById(0);

        assertEquals(3, list.size());//{symbol 555,symbol SS,symbol KK}

        assertEquals("symbol 555", list.get(0));
        assertEquals("symbol SS", list.get(1));
        assertEquals("symbol KK", list.get(2));
    }

    @Test
    public void testRemove_RemoveIntermediate_correct() {

        for (int i = 0; i < 16; i++) {
            list.addLast("symbol " + i);
        }

        String removeElement = "symbol 5";
        assertTrue(list.remove(removeElement));
        assertEquals(15, list.size());

        for (int i = 0; i < 5; i++) {
            assertEquals("symbol " + i, list.get(i));
        }

        for (int i = 5; i < list.size(); i++) {
            assertEquals("symbol " + (i + 1), list.get(i));
        }
    }

    @Test
    public void testRemove_RemoveFirst_correct() {

        for (int i = 0; i < 16; i++) {
            list.addLast("symbol " + i);
        }

        assertTrue(list.remove("symbol 0"));
        assertEquals(15, list.size());
        assertEquals("symbol 15", list.get(14));

        for (int i = 1; i < list.size(); i++) {
            assertEquals("symbol " + (i + 1), list.get(i));
        }
    }

    @Test
    public void testRemove_RemoveLast_correct() {

        createArrayList(16);

        assertTrue(list.remove("symbol P"));
        assertEquals(15, list.size());

    }

    @Test
    public void testContains_First_Intermediate_Last_correct() {

        createArrayList(16);

        assertTrue(list.contains("symbol A"));
        assertTrue(list.contains("symbol C"));
        assertTrue(list.contains("symbol P"));

    }

    @Test
    public void testContains_searchNull_correct() {

        list.addLast("symbol SS");
        list.addLast(null);
        list.addLast("symbol KK");

        assertTrue(list.contains(null));


    }

    @Test
    public void testRemove_Object_Null_true() {

        list.addLast("symbol SS");
        list.addLast(null);
        list.addLast("symbol KK");

        assertTrue(list.remove(null));


    }

    @Test
    public void testRemove_Null_WithoutNullElement_false() {

        list.addLast("symbol SS");
        list.addLast("symbol KK");

        assertFalse(list.remove(null));

    }

    @Test
    public void test_max_severalString() {
        String[] expected = {"Evgenievna", "Vladislava", "Borisovich", "Evgeny"};

        list.addLast("Evgeny");
        list.addLast("Borisovich");
        list.addLast("Vladislava");
        list.addLast("Evgenievna");
        assertEquals("Vladislava", list.max());
    }

    @Test
    public void testComparator_Max_Integer() {

        listInteger.addLast(5);
        listInteger.addLast(15);
        listInteger.addLast(1);
        listInteger.addLast(0);
        listInteger.addLast(102);
        listInteger.addLast(1102);

        assertEquals(listInteger.maxComparator(new Comparator<Integer>(){
            @Override
           public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        }),1102);

    }
    @Test
    public void testComparator_Min_Integer() {

        listInteger.addLast(5);
        listInteger.addLast(15);
        listInteger.addLast(1);
        listInteger.addLast(-15);
        listInteger.addLast(-102);
        listInteger.addLast(1102);

       assertFalse(listInteger.maxComparator(new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
                return o1-o2;
           }
       })==-102);


    }
    @Test
    public void test_maxComparator_emptyList() {
        assertThrows(NoSuchElementException.class, () -> listInteger.maxComparator(new IntegerBasicComparator()));
    }

    @Test
    public void test_minComparator_emptyList() {
        IntegerBasicComparator comparator=new IntegerBasicComparator();
        assertThrows(NoSuchElementException.class, () -> listInteger.minComparator(comparator));
    }

    @Test
    public void test_Sort_String() {


        list.addLast("Evgeny");
        list.addLast("Borisovich");
        list.addLast("Vladislava");
        list.addLast("Evgenievna");
        list.sort(new StringBasicComparator());
        System.out.println(list);
        String[] stringsTest={"Borisovich","Evgenievna", "Evgeny", "Vladislava"};

        for (int i = 0; i < stringsTest.length; i++) {
            assertEquals(list.get(i),stringsTest[i]);
        }

    }
    @Test
    public void test_Sort_Integer() {


        listInteger.addLast(5);
        listInteger.addLast(15);
        listInteger.addLast(1);
        listInteger.addLast(102);
        listInteger.sort(new IntegerBasicComparator());
        System.out.println(listInteger);

        int[] arrtest={1,5,15,102};
        for (int i = 0; i < arrtest.length; i++) {
            assertEquals(listInteger.get(i),arrtest[i]);
        }
    }

    public void createArrayList(int index) {

        String symbol = "symbol ";
        for (char i = 65; i < (65 + index); i++) {
            list.addLast(symbol + i);
        }
    }

}
