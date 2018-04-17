package shapes;

public class Square implements Shape{
    int width;

    public Square(int width) {
        this.width =width;
    }

    @Override
    public double area() {
        return width*width;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return width;
    }
}
