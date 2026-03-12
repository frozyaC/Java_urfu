package task_9;

public class task9_main {
    public static void main(String[] args) {
        Shape circle = new Circle("Красный", 5.0);
        Shape square = new Square("Синий", 4.0);
        Shape triangle = new Triangle("Зелёный", 3.0, 4.0, 5.0);

        System.out.println("Круг:");
        System.out.println("Цвет: " + circle.getColor());
        System.out.println("Площадь: " + circle.getArea());
        System.out.println("Периметр: " + circle.getPerimeter());

        System.out.println("\nКвадрат:");
        System.out.println("Цвет: " + square.getColor());
        System.out.println("Площадь: " + square.getArea());
        System.out.println("Периметр: " + square.getPerimeter());

        System.out.println("\nТреугольник:");
        System.out.println("Цвет: " + triangle.getColor());
        System.out.println("Площадь: " + triangle.getArea());
        System.out.println("Периметр: " + triangle.getPerimeter());
    }
}
