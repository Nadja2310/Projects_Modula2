package telran.shaps.entity;

public class Rectangle extends Shape {
    int height;
    int width;

    public Rectangle(char symbol, int height, int width) {
        super(symbol);
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                builder.append(symbol).append(" ");
            }
            builder.append(System.lineSeparator());
        }
        System.out.println(builder);
    }
}

