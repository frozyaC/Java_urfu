package task_8;

public class Cat extends Animal {
    private String foodType;

    public Cat(String name, int age, String foodType) {
        super(name, age);
        this.foodType = foodType;
    }

    public String getFoodType() {
        return foodType;
    }

    @Override
    public void makeSound() {
        System.out.println("Мяу-мяу!");
    }

    public void scratch() {
        System.out.println(getName() + " точит когти!");
    }
}
