package com.pluralsight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class AccountingApp {//Home screen
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nHome Screen:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Enter your choice: ");
            String choice = input.nextLine().toUpperCase();

            switch (choice) {
                case "D":
                    System.out.print("Enter description: ");
                    String depositDesc = input.nextLine();
                    System.out.print("Enter vendor: ");
                    String depositVendor = input.nextLine();
                    System.out.print("Enter amount: ");
                    double depositAmount = Double.parseDouble(input.nextLine());

                    //creates a new deposit and saves it to csv
                    Transaction deposit = new Transaction(LocalDateTime.now(), depositDesc, depositVendor, depositAmount);
                    TransactionManager.saveTransaction(deposit);
                    System.out.println("Deposit added,");
                    break;

                case "P":
                    System.out.print("Enter description: ");
                    String paymentDesc = input.nextLine();
                    System.out.print("Enter vendor: ");
                    String paymentVendor = input.nextLine();
                    System.out.print("Enter amount: ");
                    double paymentAmount = Double.parseDouble(input.nextLine());

                    //creates and stores a negative value since it is a payment allowing us to find all payments
                    Transaction payment = new Transaction(LocalDateTime.now(), paymentDesc, paymentVendor, -Math.abs(paymentAmount));
                    TransactionManager.saveTransaction(payment);
                    System.out.println("Payment added.");
                    break;

                case "L":
                    List<Transaction> transactions = TransactionManager.loadTransactions();
                    Ledger.displayLedgerScreen(transactions);
                    break;
                case "X":
                    System.out.println("Exiting....");
                    return;
                default:
                    System.out.println("\n------Please choose a valid option------");
            }
        }
    }
}
