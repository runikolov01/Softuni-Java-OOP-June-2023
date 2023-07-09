package T05Polymorphism.L02Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculateArea() {
        return 2 * Math.PI * radius;
    }
}
