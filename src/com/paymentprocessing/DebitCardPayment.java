package com.paymentprocessing;


public class DebitCardPayment extends Payment {

    private String cardNumber;
    private String pin;
    private double accountBalance;

    public DebitCardPayment(String paymentId, double amount,
                            String cardNumber, String pin,
                            double accountBalance) {

        super(paymentId, amount);
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.accountBalance = accountBalance;
    }

    @Override
    public boolean validatePayment() {

        if (cardNumber.length() == 16) {
            if (pin.length() == 4) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean processPayment() {

        if (getAmount() > accountBalance) {
            System.out.println("Insufficient Balance!");
            return false;
        } else {
            accountBalance -= getAmount();
            System.out.println("Payment Successful.");
            System.out.println("Remaining Balance: " + accountBalance);
            return true;
        }
    }

    @Override
    public void displayPaymentInfo() {
        System.out.println("---- Debit Card Payment ----");
        super.displayPaymentInfo();
    }
}
