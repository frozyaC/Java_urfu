package task8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CarDeserealization {
    public static void main(String[] args) {
        String fileName = "code/files/task8/car.ser";

        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Car car = (Car) in.readObject();
            System.out.println("Прочитанный из файла " + fileName + " автомобиль:");
            System.out.println("Марка: " + car.getMake());
            System.out.println("Модель: " + car.getModel());
            System.out.println("Год выпуска: " + car.getYear());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}