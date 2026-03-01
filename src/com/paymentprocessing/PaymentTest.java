package com.paymentprocessing;



public class PaymentTest {

    public static void main(String[] args) {

        // Runtime Polymorphism (Upcasting)
        Payment p1 = new CreditCardPayment(
                "CC101", 5000,
                "1234567812345678",
                "Akash",
                "123",
                "12/26");

        Payment p2 = new DebitCardPayment(
                "DC101", 3000,
                "1234567812345678",
                "1234",
                10000);

        Payment p3 = new UPIPayment(
                "UPI101", 2000,
                "akash@upi",
                "5678");

        Payment p4 = new DebitCardPayment(
                "DC102", 20000,
                "1234567812345678",
                "1234",
                5000); // insufficient balance

        Payment p5 = new CreditCardPayment(
                "CC102", 4000,
                "1234",  // invalid card number
                "Akash",
                "123",
                "12/26");

        Payment p6 = new UPIPayment(
                "UPI102", 1000,
                "invalidupi",  // invalid format
                "1234");

        Payment[] payments = {p1, p2, p3, p4, p5, p6};

        for (Payment payment : payments) {
            payment.initiatePayment();
            payment.displayPaymentInfo();
            System.out.println("-----------------------------");
        }
    }
}