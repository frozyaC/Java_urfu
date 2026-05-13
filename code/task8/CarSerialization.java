package task8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CarSerialization {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2020);
        String fileName = "code/files/task8/car.ser";

        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(car);
            System.out.println("Данные автомобиля сохранены в car.ser");
        } catch (IOException e) {
            e.printStackTrace();
    }
}
}
