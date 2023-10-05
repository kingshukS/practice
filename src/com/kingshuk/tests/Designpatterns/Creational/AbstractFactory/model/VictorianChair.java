package com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.model;

public class VictorianChair implements Chair{

    @Override
    public void sitOn() {
        System.out.println("Sitting on victorian chair");
    }
}
