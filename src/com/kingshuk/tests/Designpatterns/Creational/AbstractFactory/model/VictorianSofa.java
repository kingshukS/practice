package com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.model;

public class VictorianSofa implements Sofa {
    @Override
    public void sleepOn () {
        System.out.println ( "Sleeping on victorian sofa" );
    }
}
