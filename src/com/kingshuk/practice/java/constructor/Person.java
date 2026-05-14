package com.kingshuk.practice.java.constructor;

public class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    Person(Person p) {
        this(p.name);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Person p1 = new Person("John");
        Person p2 = new Person(p1);
        System.out.println(p1.getName());
        System.out.println(p2.getName());
        p1.setName("Jane");
        System.out.println(p1.getName());
        System.out.println(p2.getName());
    }
}
