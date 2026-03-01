package com.paymentprocessing;



public class UPIPayment extends Payment {

    private String upiId;
    private String pin;

    public UPIPayment(String paymentId, double amount,
                      String upiId, String pin) {

        super(paymentId, amount);
        this.upiId = upiId;
        this.pin = pin;
    }

    @Override
    public boolean validatePayment() {

        if (upiId.contains("@")) {
            if (pin.length() == 4) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean processPayment() {

        if (getAmount() > 100000) {
            System.out.println("Transaction limit exceeded!");
            return false;
        } else {
            System.out.println("UPI Payment Successful.");
            return true;
        }
    }

    @Override
    public void displayPaymentInfo() {
        System.out.println("---- UPI Payment ----");
        super.displayPaymentInfo();
    }
}
