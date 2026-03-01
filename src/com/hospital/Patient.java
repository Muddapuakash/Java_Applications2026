package com.hospital;

public class Patient extends Person {

    private int age;

    public Patient(int id, String name, int age) {
        super(id, name);
        this.age = age;
    }

    public int getId() {
        return id;
    }

    @Override
    public void display() {
        System.out.println("Patient ID: " + id + ", Name: " + name + ", Age: " + age);
    }
}
