package telran.shaps.entity;

import java.util.List;

public class Picture extends Shape{
    private List<Shape> shapes;
    private final int lengthPage = 30;

    public Picture(char symbol, List<Shape> shapes) {
        super(symbol);
        this.shapes = shapes;
    }

    @Override
    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
