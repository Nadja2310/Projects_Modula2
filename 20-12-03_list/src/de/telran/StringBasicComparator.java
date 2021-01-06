package de.telran;

import java.util.Comparator;

public class StringBasicComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
}
