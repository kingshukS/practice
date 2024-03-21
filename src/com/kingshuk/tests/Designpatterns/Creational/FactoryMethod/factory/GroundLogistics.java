package com.kingshuk.tests.Designpatterns.Creational.FactoryMethod.factory;

import com.kingshuk.tests.Designpatterns.Creational.FactoryMethod.model.Transport;
import com.kingshuk.tests.Designpatterns.Creational.FactoryMethod.model.Truck;

public class GroundLogistics extends Logistics {

    @Override
    protected Transport createTransport () {
        return new Truck ();
    }
}
