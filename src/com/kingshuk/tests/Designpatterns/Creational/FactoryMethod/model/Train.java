package com.kingshuk.tests.Designpatterns.Creational.FactoryMethod.model;

public class Train implements Transport{
    @Override
    public void deliver() {
        System.out.println("Train delivery :: Ground Transportation");
    }
}
