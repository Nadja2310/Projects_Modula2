package telran.shaps.entity;

public class Line extends Shape {
    int length;

    public Line(char symbol, int length) {
        super(symbol);
        this.length = length;
    }

    @Override
    public void draw() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.length; i++) {
            builder.append(symbol).append(" ");
        }
        System.out.println(builder);
    }
}
