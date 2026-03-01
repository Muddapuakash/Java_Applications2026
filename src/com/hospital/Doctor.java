package com.hospital;

public class Doctor extends Person {

    private String specialization;
    private boolean available = true;

    public Doctor(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean status) {
        this.available = status;
    }

    @Override
    public void display() {
        System.out.println("Doctor ID: " + id +
                ", Name: " + name +
                ", Specialization: " + specialization +
                ", Available: " + available);
    }
}
