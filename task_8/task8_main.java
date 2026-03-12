package task_8;

public class task8_main {
    public static void main(String[] args) {
        Dog dog = new Dog("\nБобик", 3, "Овчарка");
        Cat cat = new Cat("Мурка", 2, "Сухой корм");
        Bird bird = new Bird("Кеша", 1, true);

        System.out.println("Собака: " + dog.getName() + ", возраст: " + dog.getAge() + ", порода: " + dog.getBreed());
        dog.makeSound();
        dog.fetch();

        System.out.println("\nКошка: " + cat.getName() + ", возраст: " + cat.getAge() + ", корм: " + cat.getFoodType());
        cat.makeSound();
        cat.scratch();

        System.out.println("\nПтица: " + bird.getName() + ", возраст: " + bird.getAge() + ", летает: " + bird.canFly());
        bird.makeSound();
        bird.fly();
    }
}
