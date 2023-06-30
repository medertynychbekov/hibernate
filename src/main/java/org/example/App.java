package org.example;

import org.example.model.Car;
import org.example.service.Service;
import org.example.service.impl.CarService;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Service<Car> carService = new CarService();

        carService.save(new Car("BMW", 123, "M5"));

        carService.update(8, new Car("BMW", 123, "M5"));

        // System.out.println(carService.getAll());

        // carService.getAll().forEach(System.out::println);
    }
}
