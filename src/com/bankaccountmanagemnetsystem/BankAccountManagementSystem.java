package com.bankaccountmanagemnetsystem;

import java.util.*;

public class BankAccountManagementSystem {

 // Deposit Method
 public static void deposit(List<Account> accounts, int accountId, double amount) {
     for (Account acc : accounts) {
         if (acc.id == accountId) {
             acc.balance += amount;
         }
     }
 }

 // Withdraw Method
 public static void withdraw(List<Account> accounts, int accountId, double amount) {
     for (Account acc : accounts) {
         if (acc.id == accountId && acc.balance >= amount) {
             acc.balance -= amount;
         }
     }
 }

 // Remove accounts with low balance
 public static void removeLowBalance(List<Account> accounts, double minBalance) {
	    Iterator<Account> iterator = accounts.iterator();

	    while (iterator.hasNext()) {
	        Account acc = iterator.next();

	        if (acc.balance < minBalance) {
	            iterator.remove();
	        }
	    }
	}

 public static void main(String[] args) {

     // Customer List
     List<Customers> customer = new ArrayList<>();
     customer.add(new Customers(1, "John", "Hyderabad"));
     customer.add(new Customers(2, "Alice", "Chennai"));
     customer.add(new Customers(3, "Bob", "Hyderabad"));

     // Account List
     List<Account> accounts = new ArrayList<>();
     accounts.add(new Account(101, 1, 5000, "Savings"));
     accounts.add(new Account(102, 2, 10000, "Current"));
     accounts.add(new Account(103, 3, 3000, "Savings"));

     // Perform operations
     deposit(accounts, 101, 2000);   
     withdraw(accounts, 102, 1000);  
     removeLowBalance(accounts, 2000);

     // Linking using Map
     Map<Integer, Customers> customerMap = new HashMap<>();
     for (Customers c : customer) {
         customerMap.put(c.id, c);
     }

     // Output

     System.out.println("Customers from Hyderabad:");
     for (Customers c : customer) {
         if (c.city.equalsIgnoreCase("Hyderabad")) {
             System.out.println(c.name);
         }
     }

     System.out.println("\nAccounts with balance > 5000:");
     for (Account a : accounts) {
         if (a.balance > 5000) {
             System.out.println(a.id + " -> " + (int)a.balance);
         }
     }

     System.out.println("\nSorted Accounts:");

     accounts.sort((a, b) -> Double.compare(b.balance, a.balance));

     for (Account a : accounts) {
         System.out.println(a.id + " -> " + (int)a.balance);
     }

     System.out.println("\nAccount-Customer Mapping:");
     for (Account a : accounts) {
         Customers c = customerMap.get(a.customerId);
         System.out.println(a.id + " -> " + c.name + " -> " + (int)a.balance);
     }
 }
}
