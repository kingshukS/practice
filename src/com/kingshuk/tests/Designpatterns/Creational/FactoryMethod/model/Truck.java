package com.kingshuk.tests.Designpatterns.Creational.FactoryMethod.model;

public class Truck implements Transport {
    @Override
    public void deliver () {
        System.out.println ( "Truck delivery :: Ground Transportation" );
    }
}
