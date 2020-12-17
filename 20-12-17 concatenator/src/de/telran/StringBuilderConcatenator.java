package de.telran;

public class StringBuilderConcatenator implements IConcatenator{
    @Override
    public void concatenate(String[] strings) {
        StringBuilder builder = new StringBuilder();
        for (String str:strings) {
            builder.append(str);
        }
       // System.out.println(builder);
    }
}
