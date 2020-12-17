package de.telran;

public class StringConcatenator implements IConcatenator{

    @Override
    public void concatenate(String[] strings) {
        String outputStr="";
        for (String str:strings) {
            outputStr+=str;
        }
       // System.out.println(outputStr);
    }
}
