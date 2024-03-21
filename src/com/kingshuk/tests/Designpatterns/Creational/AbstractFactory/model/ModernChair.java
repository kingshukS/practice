package com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.model;

public class ModernChair implements Chair {
    @Override
    public void sitOn () {
        System.out.println ( "Sitting on modern chair" );
    }
}
