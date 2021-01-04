package de.telran;

public class Main {
    public static void main(String[] args) {
        StackMax stackMax = new StackMax();
        stackMax.addLast(12);
        stackMax.addLast(222);
        stackMax.addLast(2);
        stackMax.addLast(32);
        stackMax.addLast(222);
        stackMax.addLast(221);
        stackMax.removeLast();

        System.out.println(stackMax.getMax());

    }

}
