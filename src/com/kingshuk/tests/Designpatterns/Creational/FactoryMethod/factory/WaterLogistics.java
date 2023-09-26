package com.kingshuk.tests.Designpatterns.Creational.FactoryMethod.factory;

import com.kingshuk.tests.Designpatterns.Creational.FactoryMethod.model.Ship;
import com.kingshuk.tests.Designpatterns.Creational.FactoryMethod.model.Transport;

public class WaterLogistics extends Logistics{
    @Override
    protected Transport createTransport() {
        return new Ship();
    }
}
