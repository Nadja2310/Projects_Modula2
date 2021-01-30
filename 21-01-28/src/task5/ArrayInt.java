package task5;

import java.util.HashMap;
import java.util.Map;

public class ArrayInt {

    public HashMap<Integer, Integer> searchFrequentElement(int[] array) {

        HashMap<Integer, Integer> occurenceByNumber = new HashMap<>();
        for (int element : array) {

            int oldValue=occurenceByNumber.containsKey(element)?occurenceByNumber.get(element)+1:1;
            occurenceByNumber.put(element,oldValue);
        }

        return occurenceByNumber;
    }

}
