package com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.model;

public class ModernSofa implements Sofa {
    @Override
    public void sleepOn () {
        System.out.println ( "Sleeping on modern sofa" );
    }
}
