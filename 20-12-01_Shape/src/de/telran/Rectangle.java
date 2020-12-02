package de.telran;

public class Rectangle extends Shape {
    int height;
    int width;

    public Rectangle(char symbol, int height, int width) {
        super(symbol);
        this.height = height;
        this.width = width;
    }

    @Override
    void draw() {
        for (int i = 0; i < this.width; i++) {
            System.out.print(this.symbol);
        }
        System.out.println();
        for (int i = 1; i < this.height - 1; i++) {

            System.out.print(this.symbol);
            for (int j = 1; j < this.width - 1; j++) {
                System.out.print(" ");
            }
            System.out.print(this.symbol);
            System.out.println();

        }
        for (int i = 0; i < this.width; i++) {
            System.out.print(this.symbol);
        }
    }
}
