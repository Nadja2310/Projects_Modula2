package collect;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListService {
    public int sumOfSquareOfNumbers(List<Integer> list) {
        return list.stream()
                .collect(Collectors.summingInt(number -> number * number));
    }

    public Map<Boolean, List<String>> verifyPalindrome(List<String> list) {

        return list.stream()
                .collect(Collectors.partitioningBy(this::isPalindrome));

    }

    private boolean isPalindrome(String str) {
        String inputStr = str.replaceAll(" ", "").toLowerCase();
        StringBuilder stringBuilder = new StringBuilder(inputStr);
        StringBuilder stringBuilderRevers = stringBuilder.reverse();
        return stringBuilderRevers.toString().equals(inputStr);
    }
}
