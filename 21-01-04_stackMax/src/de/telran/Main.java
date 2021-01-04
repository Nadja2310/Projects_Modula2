package de.telran;

public class Main {
    public static void main(String[] args) {
        StackMax stackMax = new StackMax();
        stackMax.addLast(12);
        stackMax.addLast(222);
        stackMax.addLast(2);
        stackMax.addLast(32);
        System.out.println(stackMax.getMax());

    }

}
