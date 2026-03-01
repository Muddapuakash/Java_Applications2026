package com.paymentprocessing;


public abstract class Payment {

    // Private fields (Encapsulation)
    private String paymentId;
    private double amount;
    private String status;

    // Constructor
    public Payment(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = "PENDING";
    }

    // Abstract methods
    public abstract boolean validatePayment();
    public abstract boolean processPayment();

    // Concrete method (Common logic)
    public void initiatePayment() {
        if (amount > 0) {
            if (validatePayment()) {
                if (processPayment()) {
                    status = "SUCCESS";
                } else {
                    status = "FAILED";
                }
            } else {
                status = "FAILED";
            }
        } else {
            status = "FAILED";
        }
    }

    public void displayPaymentInfo() {
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Amount: " + amount);
        System.out.println("Status: " + status);
    }

    // Getters
    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}
