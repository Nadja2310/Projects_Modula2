package task1;

import java.util.*;

public class Solv {
    public HashSet<Integer> setlist(List<Integer> listInt) {
        HashSet<Integer> outputSet = new HashSet<>();
        for (Integer elm : listInt) {
            outputSet.add(elm);
        }
        return outputSet;
    }

}
