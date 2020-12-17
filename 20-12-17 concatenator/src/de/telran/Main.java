package de.telran;

public class Main {
    public static void main(String[] args) {
        String[] string1 = {"ab", "bc", "cd", "de"};
        IConcatenator str = new StringConcatenator();
        str.concatenate(string1);
        StringBuilderConcatenator builderStr = new StringBuilderConcatenator();
        str.concatenate(string1);
        ConcatinationTester testStr = new ConcatinationTester(new StringConcatenator());
        testStr.test(10000, "hi");

        ConcatinationTester testStr1 = new ConcatinationTester(new StringBuilderConcatenator());
        testStr.test(10000, "hi");

    }
}
