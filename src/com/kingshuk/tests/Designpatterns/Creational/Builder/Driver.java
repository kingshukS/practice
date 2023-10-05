package com.kingshuk.tests.Designpatterns.Creational.Builder;

import com.kingshuk.tests.Designpatterns.Creational.Builder.builder.CarBuilder;
import com.kingshuk.tests.Designpatterns.Creational.Builder.builder.CarManualBuilder;
import com.kingshuk.tests.Designpatterns.Creational.Builder.director.Director;
import com.kingshuk.tests.Designpatterns.Creational.Builder.model.Car;
import com.kingshuk.tests.Designpatterns.Creational.Builder.model.Manual;

/**
 * Demo class. Everything comes together here.
 */
public class Driver {

    public static void main(String[] args) {
        Director director = new Director();

        // Director gets the concrete builder object from the client
        // (application code). That's because application knows better which
        // builder to use to get a specific product. Also, the getResult() is not
        // defined in builder class as concrete builders are generating objects which
        // are not of any common interface type.
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        // The final product is often retrieved from a builder object, since
        // Director is not aware and not dependent on concrete builders and
        // products.
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());


        CarManualBuilder manualBuilder = new CarManualBuilder();

        // Director may know several building recipes.
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }

}