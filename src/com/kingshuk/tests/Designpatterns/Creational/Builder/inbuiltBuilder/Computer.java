package com.kingshuk.tests.Designpatterns.Creational.Builder.inbuiltBuilder;

import java.util.StringJoiner;

public class Computer {

    // required
    private int ssd;
    private int ram;
    private String processor;
    private String cabinet;
    private String keyboard;
    private String mouse;

    // optional
    private boolean isGameMode;
    private boolean isBluetoothEnabled;
    private String graphicCard;
    private int graphicMemory;
    private int smps;
    private String gamepad;
    private Computer(){}

    private Computer(ComputerBuilder builder) {
        this.ssd = builder.ssd;
        this.ram = builder.ram;
        this.processor = builder.processor;
        this.cabinet = builder.cabinet;
        this.keyboard = builder.keyboard;
        this.mouse = builder.mouse;

        this.isGameMode = builder.isGameMode;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.smps = builder.smps;
        this.graphicCard = builder.graphicCard;
        this.graphicMemory = builder.graphicMemory;
        this.gamepad = builder.gamepad;
    }

    public int getSsd() {
        return ssd;
    }

    public int getRam() {
        return ram;
    }

    public String getProcessor() {
        return processor;
    }

    public String getCabinet() {
        return cabinet;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public String getMouse() {
        return mouse;
    }

    public boolean isGameMode() {
        return isGameMode;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public int getGraphicMemory() {
        return graphicMemory;
    }

    public int getSmps() {
        return smps;
    }

    public String getGamepad() {
        return gamepad;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Computer.class.getSimpleName() + "[", "]")
                .add("ssd=" + ssd)
                .add("ram=" + ram)
                .add("processor='" + processor + "'")
                .add("cabinet='" + cabinet + "'")
                .add("keyboard='" + keyboard + "'")
                .add("mouse='" + mouse + "'")
                .add("isGameMode=" + isGameMode)
                .add("isBluetoothEnabled=" + isBluetoothEnabled)
                .add("graphicCard='" + graphicCard + "'")
                .add("graphicMemory=" + graphicMemory)
                .add("smps=" + smps)
                .add("gamepad='" + gamepad + "'")
                .toString();
    }

    public static class ComputerBuilder{
        // required fields
        private final int ssd;
        private final int ram;
        private final String processor;
        private final String cabinet;
        private final String keyboard;
        private final String mouse;

        // optional fields
        private boolean isGameMode;
        private boolean isBluetoothEnabled;
        private String graphicCard;
        private int graphicMemory;
        private int smps;
        private String gamepad;

        public ComputerBuilder(int ssd, int ram, String processor, String cabinet, String keyboard, String mouse) {
            this.ssd = ssd;
            this.ram = ram;
            this.processor = processor;
            this.cabinet = cabinet;
            this.keyboard = keyboard;
            this.mouse = mouse;
        }

        public ComputerBuilder gamingMode(boolean isGameMode) {
            this.isGameMode = isGameMode;
            return this;
        }

        public ComputerBuilder bluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public ComputerBuilder graphicCard(String graphicCard) {
            this.graphicCard = graphicCard;
            return this;
        }

        public ComputerBuilder smps(int smps) {
            this.smps = smps;
            return this;
        }

        public ComputerBuilder graphicMemory(int graphicMemory) {
            this.graphicMemory = graphicMemory;
            return this;
        }

        public ComputerBuilder gamepad(String gamepad) {
            this.gamepad = gamepad;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }


}
