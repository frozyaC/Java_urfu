package task_8;

public class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Гав-гав!");
    }

    public void fetch() {
        System.out.println(getName() + " приносит мяч!");
    }
}
