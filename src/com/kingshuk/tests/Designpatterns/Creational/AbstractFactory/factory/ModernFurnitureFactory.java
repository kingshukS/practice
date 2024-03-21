package com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.factory;

import com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.model.Chair;
import com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.model.ModernChair;
import com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.model.ModernSofa;
import com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.model.Sofa;

public class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair () {
        return new ModernChair ();
    }

    @Override
    public Sofa createSofa () {
        return new ModernSofa ();
    }
}
