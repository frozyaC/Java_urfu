package task_6;

public class task6_main {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        Shape square = new Square(3.3);
        Shape triangle = new Triangle(3.0, 4.5, 3.2);

        System.out.println("\nПлощадь круга: " + circle.getArea());
        System.out.println("Периметр круга: " + circle.getPerimeter());

        System.out.println("Площадь квадрата: " + square.getArea());
        System.out.println("Периметр квадрата: " + square.getPerimeter());

        System.out.println("Площадь треугольника: " + triangle.getArea());
        System.out.println("Периметр круга: " + triangle.getPerimeter());


    }
}
