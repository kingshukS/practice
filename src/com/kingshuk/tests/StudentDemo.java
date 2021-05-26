package com.kingshuk.tests;

import java.util.Arrays;
import java.util.Scanner;

public class StudentDemo {
    public static void main(String[] args) {
        Student student = getStudentDetails();
        student.calculateAvg();
        student.findGrade();
        System.out.println(student);
    }

    public static Student getStudentDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the number of subjects:");
        int num = scanner.nextInt();
        int[] marks = new int[num];
        for(int i = 0; i<num; i++){
            System.out.println("Enter mark for subject:"+(i+1));
            int mark = scanner.nextInt();
            marks[i] = mark;
        }
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setMarks(marks);
        return student;
    }
}

class Student{
    private int id;
    private String name;
    private int[] marks;
    private float avg = 0.0f;
    private char grade = 'A';

    public Student(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public void calculateAvg() {
        int sum = 0;
        for(int i=0; i<marks.length; i++){
            sum+=marks[i];
        }
        float avg = (float)sum/marks.length;
        this.setAvg(avg);
    }

    public void findGrade(){
        // find the grade
    }

    @Override
    public String toString() {
        return "id=" + id + "\n"+
                "name=" + name +"\n"+
                "marks=" + Arrays.toString(marks) +"\n"+
                "avg=" + avg +"\n"+
                "grade=" + grade;
    }
}
