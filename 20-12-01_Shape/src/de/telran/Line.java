package de.telran;

public class Line extends Shape {
    int length;

    public Line(char symbol, int length) {
        super(symbol);
        this.length = length;
    }

    @Override
    void draw() {
        for (int i = 0; i < this.length; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}
