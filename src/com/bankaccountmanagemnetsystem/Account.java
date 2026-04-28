package com.bankaccountmanagemnetsystem;

public class Account {
 int id;
 int customerId;
 double balance;
 String type;

 public Account(int id, int customerId, double balance, String type) {
     this.id = id;
     this.customerId = customerId;
     this.balance = balance;
     this.type = type;
 }
}