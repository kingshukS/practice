package com.kingshuk.tests.Designpatterns.Creational.FactoryMethod.factory;

import com.kingshuk.tests.Designpatterns.Creational.FactoryMethod.model.Transport;

public abstract class Logistics {
    public void planDelivery () {
        Transport transport = createTransport ();
        transport.deliver ();
    }

    protected abstract Transport createTransport ();
}
