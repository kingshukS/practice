package com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.factory;

import com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.model.Chair;
import com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.model.Sofa;
import com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.model.VictorianChair;
import com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.model.VictorianSofa;

public class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair () {
        return new VictorianChair ();
    }

    @Override
    public Sofa createSofa () {
        return new VictorianSofa ();
    }
}
