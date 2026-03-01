package com.paymentprocessing;

public class CreditCardPayment extends Payment {

    private String cardNumber;
    private String cardHolderName;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String paymentId, double amount,
                             String cardNumber, String cardHolderName,
                             String cvv, String expiryDate) {

        super(paymentId, amount); // Constructor chaining
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean validatePayment() {

        if (cardNumber.length() == 16) {
            if (cvv.length() == 3) {
                if (cardHolderName != null && !cardHolderName.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean processPayment() {

        if (getAmount() > 10000) {
            System.out.println("Credit limit exceeded!");
            return false;
        } else {
            System.out.println("Credit Card Payment Processed.");
            return true;
        }
    }

    @Override
    public void displayPaymentInfo() {
        System.out.println("---- Credit Card Payment ----");
        super.displayPaymentInfo();
    }
}
