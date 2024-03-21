package com.kingshuk.tests.Designpatterns.Creational.Builder.components;

public class GPSNavigator {
    private final String route;

    public GPSNavigator () {
        this.route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London";
    }

    public GPSNavigator ( String manualRoute ) {
        this.route = manualRoute;
    }

    public String getRoute () {
        return route;
    }
}
