package com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.factory;

import com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.model.Chair;
import com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.model.Sofa;

public interface FurnitureFactory {
    Chair createChair ();

    Sofa createSofa ();
}
