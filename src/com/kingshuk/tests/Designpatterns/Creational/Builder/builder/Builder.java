package com.kingshuk.tests.Designpatterns.Creational.Builder.builder;

import com.kingshuk.tests.Designpatterns.Creational.Builder.components.*;

public interface Builder {
    void setCarType ( CarType type );

    void setSeats ( int seats );

    void setEngine ( Engine engine );

    void setTransmission ( Transmission transmission );

    void setTripComputer ( TripComputer tripComputer );

    void setGPSNavigator ( GPSNavigator gpsNavigator );
}
