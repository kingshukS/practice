package com.kingshuk.tests.Designpatterns.Creational.FactoryMethod.model;

public class Ship implements Transport{
    @Override
    public void deliver() {
        System.out.println("Ship delivery :: Water Transportation");
    }
}
