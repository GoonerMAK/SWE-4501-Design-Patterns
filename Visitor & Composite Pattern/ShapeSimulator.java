import java.util.ArrayList;
import java.util.List;

// Component interface
interface Shape {
    void accept(ShapeVisitor visitor);
}

// Leaf node 1
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

// Leaf node 2
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

// Composite node
class CompositeShape implements Shape {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        for (Shape shape : shapes) {
            shape.accept(visitor);
        }
        visitor.visit(this);
    }
}

// Visitor interface
interface ShapeVisitor {
    void visit(Circle circle);

    void visit(Rectangle rectangle);

    void visit(CompositeShape compositeShape);
}

// Concrete visitor implementation
class AreaCalculator implements ShapeVisitor {
    private double totalArea = 0;

    public double getTotalArea() {
        return totalArea;
    }

    @Override
    public void visit(Circle circle) {
        double area = Math.PI * Math.pow(circle.getRadius(), 2);
        System.out.println("Calculating area for Circle: " + area);
        totalArea += area;
    }

    @Override
    public void visit(Rectangle rectangle) {
        double area = rectangle.getWidth() * rectangle.getHeight();
        System.out.println("Calculating area for Rectangle: " + area);
        totalArea += area;
    }

    @Override
    public void visit(CompositeShape compositeShape) {
        System.out.println("Calculating area for CompositeShape");
    }
}


public class ShapeSimulator {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);

        CompositeShape compositeShape = new CompositeShape();
        compositeShape.addShape(circle);
        compositeShape.addShape(rectangle);

        AreaCalculator areaCalculator = new AreaCalculator();
        compositeShape.accept(areaCalculator);

        System.out.println("Total area: " + areaCalculator.getTotalArea());
    }
}
