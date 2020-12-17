package de.telran;

public class ConcatinationTester {
    private IConcatenator concatenator;

    public ConcatinationTester(IConcatenator concatenator) {
        this.concatenator = concatenator;
    }

    public void test(int time, String text) {
        long beforeConcatenation = System.currentTimeMillis();
        concatenator.concatenate(composeArray(time, text));
        long timeConcatenated = System.currentTimeMillis() - beforeConcatenation;
        System.out.println(timeConcatenated);
    }

    private String[] composeArray(int times, String text) {
        String[] outputStr = new String[times];
        for (int i = 0; i < times; i++) {
            outputStr[i] = text;
        }
        return outputStr;
    }
}
