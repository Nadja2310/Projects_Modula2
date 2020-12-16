package de.telran;

import de.telran.rule.ListRandomRule;
import de.telran.rule.RangeRandomRule;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{51, 52, 53, 56, 54, 62};
        ListRandomRule list = new ListRandomRule(array);
        System.out.println(list.nextInt());
        System.out.println(list.nextInt());
        System.out.println(list.nextInt());
        System.out.println(list.nextInt());
        System.out.println(list.nextInt());

        RandomRule randomRule = new ListRandomRule(array);
        RandomGenerator randomGenerator = new RandomGenerator(randomRule);
        System.out.println(randomGenerator.nextInts(3).toString());

        RandomRule randomRuleRange = new RangeRandomRule(20);
        RandomGenerator randomGenerator1 = new RandomGenerator(randomRuleRange);
        System.out.println(randomGenerator1.nextInts(10).toString());
    }
}
