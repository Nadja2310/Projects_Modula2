package de.telran;

public class Picture extends Shape {
    Shape shape[];
    private final int lengthPage = 20;

    public Picture(char symbol, Shape[] shape) {
        super(symbol);
        this.shape = shape;
    }

    @Override
    void draw() {
        for (int i = 0; i < lengthPage; i++) {
            System.out.print(this.symbol);
        }
        System.out.println();
        for (int i = 0; i < shape.length; i++) {
            shape[i].draw();
        }
        System.out.println();
        for (int i = 0; i < lengthPage; i++) {
            System.out.print(this.symbol);
        }
        System.out.println();
    }
}
