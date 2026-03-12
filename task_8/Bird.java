package task_8;

public class Bird extends Animal {
    private boolean canFly;

    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }

    public boolean canFly() {
        return canFly;
    }

    @Override
    public void makeSound() {
        System.out.println("Чирик-чирик!");
    }

    public void fly() {
        if (canFly) {
            System.out.println(getName() + " летит!");
        } else {
            System.out.println(getName() + " не может летать!");
        }
    }
}
