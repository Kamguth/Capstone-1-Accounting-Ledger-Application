package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class Ledger {
    public static void displayLedgerScreen(List<Transaction> transactions) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\nLedger Menu:");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Enter your choice: ");
            String choice = input.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    displayTransactions(transactions);
                    break;

                case "D":
                    List<Transaction> deposits = TransactionManager.getDeposits(transactions);
                    displayTransactions(deposits);
                    break;

                case "P":
                    List<Transaction> payments = TransactionManager.getPayments(transactions);
                    displayTransactions(payments);
                    break;

                case "R":
                    Reports.displayReportMenu(transactions);
                    break;

                case "H":
                    return;

                default:
                    System.out.println("Please select a valid option");


            }
        }
    }

    private static void displayTransactions(List<Transaction> transactions) {
        System.out.println("\nDate       | Time     | Description        | Vendor           | Amount");
        System.out.println("--------------------------------------------------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.toString());
        }
    }
}
