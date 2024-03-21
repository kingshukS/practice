package com.kingshuk.tests.Designpatterns.Creational.FactoryMethod.factory;

import com.kingshuk.tests.Designpatterns.Creational.FactoryMethod.model.Aeroplane;
import com.kingshuk.tests.Designpatterns.Creational.FactoryMethod.model.Transport;

public class AirLogistics extends Logistics {
    @Override
    protected Transport createTransport () {
        return new Aeroplane ();
    }
}
