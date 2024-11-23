package carsclasses;

import cars.CarType;
import cars.Car;

public class ElectricCar extends Car {

    public ElectricCar(String name, int hp, int weight, CarType carType) {
        super(name, hp, weight, carType);
    }

    @Override
    public void drive() {
        getWheel().steer();
    }
}
