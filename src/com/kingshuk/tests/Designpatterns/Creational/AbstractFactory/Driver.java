package com.kingshuk.tests.Designpatterns.Creational.AbstractFactory;

import com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.factory.FurnitureFactory;
import com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.factory.ModernFurnitureFactory;
import com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.factory.VictorianFurnitureFactory;
import com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.model.Chair;
import com.kingshuk.tests.Designpatterns.Creational.AbstractFactory.model.Sofa;

public class Driver {
    public static void main ( String[] args ) {
        FurnitureFactory factory = new VictorianFurnitureFactory ();
        // Victorian furniture set
        Chair chair = factory.createChair ();
        chair.sitOn ();
        Sofa sofa = factory.createSofa ();
        sofa.sleepOn ();

        factory = new ModernFurnitureFactory ();
        // Modern furniture set
        chair = factory.createChair ();
        chair.sitOn ();
        sofa = factory.createSofa ();
        sofa.sleepOn ();
    }
}
