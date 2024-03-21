package com.kingshuk.tests.Designpatterns.Behavioral.state;

public class Demo {
    public static void main ( String[] args ) {
        Player player = new Player ();
        UI ui = new UI ( player );
        ui.init ();
    }
}