package com.kingshuk.tests.Designpatterns;

abstract class VehicleFac {
    public abstract int getWheel();

    public String toString() {
        return "Wheel: " + this.getWheel();
    }
}

class Car extends VehicleFac {
    int wheel;

    Car(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

class Bike extends VehicleFac {
    int wheel;

    Bike(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

class VehicleFactory {
    public static VehicleFac getInstance(String type, int wheel) {
        if(type == "car") {
            return new Car(wheel);
        } else if(type == "bike") {
            return new Bike(wheel);
        }

        return null;
    }
}

public class FactoryPatternExample {

    public static void main(String[] args) {
        VehicleFac car = VehicleFactory.getInstance("car", 4);
        System.out.println(car);

        VehicleFac bike = VehicleFactory.getInstance("bike", 2);
        System.out.println(bike);
    }

}