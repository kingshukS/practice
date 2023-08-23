package com.kingshuk.tests.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamJava8 {
    public static void main(String args[])
    {
        List<EmployeeTest> al = new ArrayList<>();
        al.add(new EmployeeTest("nehal", 25, 150000.0));
        al.add(new EmployeeTest("suraj", 17, 178800.0));
        al.add(new EmployeeTest("riya", 25, 160000.0));
        al.add(new EmployeeTest("nitin", 26, 147700.0));
        al.add(new EmployeeTest("shubham", 26, 139900.0));

        List<String> list = al.stream().filter(p -> p.getSalary()>149999)
                .filter(p->p.getName().contains("s"))
                .map(pm->pm.getName()).collect(Collectors.toList());
        System.out.println(list);
    }
}

class EmployeeTest{
    private String name;
    private int age;
    private double salary;

    EmployeeTest(String name,int age,double salary)
    {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
