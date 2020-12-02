package de.telran;

public class Main {
    public static void main(String[] args) {

        Line line1 = new Line('-', 15);

        Rectangle rectangle1 = new Rectangle('*', 3, 20);

        Shape[] shapes = {line1, rectangle1};

        Picture picture1 = new Picture('=', shapes);

        Shape[] shapes2 = {picture1, line1, rectangle1};
        Picture picture2 = new Picture('§', shapes2);
        picture2.draw();
    }
}
