package com.kingshuk.tests.Designpatterns.Creational.FactoryMethod;

import com.kingshuk.tests.Designpatterns.Creational.FactoryMethod.factory.GroundLogistics;
import com.kingshuk.tests.Designpatterns.Creational.FactoryMethod.factory.Logistics;

public class Driver {
    public static void main ( String[] args ) {
        Logistics log = new GroundLogistics ();
        log.planDelivery ();

    }
}
