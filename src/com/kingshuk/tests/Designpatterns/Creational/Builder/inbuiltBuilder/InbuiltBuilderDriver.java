package com.kingshuk.tests.Designpatterns.Creational.Builder.inbuiltBuilder;

public class InbuiltBuilderDriver {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder(500, 16, "Intel i7", "Corsair", "Razor", "Logitech")
                .bluetoothEnabled(true).gamepad("Xbox").gamingMode(true)
                .graphicCard("NVidia").smps(1000).graphicMemory(3072).build();

        System.out.println(computer);
    }
}
