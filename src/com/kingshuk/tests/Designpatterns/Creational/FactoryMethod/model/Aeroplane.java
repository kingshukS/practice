package com.kingshuk.tests.Designpatterns.Creational.FactoryMethod.model;

public class Aeroplane implements Transport {
    @Override
    public void deliver () {
        System.out.println ( "Flight delivery :: Air Transportation" );
    }
}
