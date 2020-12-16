package de.telran.rule;

import de.telran.RandomRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListRandomRule implements RandomRule {
    List<Integer> values;
    private Random random=new Random();

    public ListRandomRule(List<Integer> list) {

        this.values = list;
    }

    public ListRandomRule(int[] numbers) {
        List<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        this.values = list;
    }

    @Override
    public int nextInt() {
      int res=(int)(Math.random()* values.size());
        return values.get(res);
    }
}
