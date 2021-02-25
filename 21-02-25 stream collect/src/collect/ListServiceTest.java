package collect;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ListServiceTest {
    ListService listService = new ListService();

    @org.junit.jupiter.api.Test
    void sumOfSquareOfNumbers() {
        assertEquals(21, listService.sumOfSquareOfNumbers(Arrays.asList(2, 4, 1)));
    }

    @org.junit.jupiter.api.Test
    void sumOfSquareOfNumbers_sum0() {
        assertEquals(0, listService.sumOfSquareOfNumbers(Arrays.asList(0)));
    }

    @org.junit.jupiter.api.Test
    void verify() {
        List<String> list = Arrays.asList("ehe", "aha", "ufo", "sort");
        Map<Boolean, List<String>> res = listService.verifyPalindrome(list);
        List<String> listTrue = Arrays.asList("ehe", "aha");
        List<String> listFalse = Arrays.asList("ufo", "sort");
        assertEquals(listTrue, res.get(true));
        assertEquals(listFalse, res.get(false));
    }

    @org.junit.jupiter.api.Test
    void verify_onlyTrue() {
        List<String> list = Arrays.asList("Город у рва мавру дорог", "У дуба буду");
        Map<Boolean, List<String>> res = listService.verifyPalindrome(list);
        List<String> listTrue = Arrays.asList("Город у рва мавру дорог", "У дуба буду");
        List<String> listFalse = Collections.emptyList();
        assertEquals(listTrue, res.get(true));
        assertEquals(listFalse, res.get(false));
    }
}