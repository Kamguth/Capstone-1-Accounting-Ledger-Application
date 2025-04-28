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

            }
        }
    }
}
