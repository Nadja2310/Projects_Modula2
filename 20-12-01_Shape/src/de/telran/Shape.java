package de.telran;

public abstract class Shape {
    char symbol;

    public Shape(char symbol) {
        this.symbol = symbol;
    }

    abstract void draw();

}
