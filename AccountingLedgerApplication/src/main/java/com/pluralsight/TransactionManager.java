package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private static String fileName = "src/main/resources/transactions.csv";

    public static List<Transaction> loadTransactions() {
        List<Transaction> transactions = new ArrayList<>(); //creates a list to store transactions
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) { //continues reading until there are no lines
                try {
                    Transaction transaction = Transaction.fromCSV(line);
                    transactions.add(transaction);
                } catch (Exception e) {
                    System.out.println("Skipping bad line: " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading transactions file", e);
        }
        return transactions;
    }
//uses br to add transaction objects to the csv
    public static void saveTransaction(Transaction transaction) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(transaction.toCSV());//returns the string formatted correctly
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }
// accessing the deposits by finding the positive values in the list
    public static List<Transaction> getDeposits(List<Transaction> transactions) {
        List<Transaction> deposits = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getAmount() > 0) {
                deposits.add(t);
            }
        }
        return deposits;
    }
// accessing the payments by finding the negative values in the list
    public static List<Transaction> getPayments(List<Transaction> transactions) {
        List<Transaction> payments = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getAmount() < 0) {
                payments.add(t);
            }
        }
        return payments;
    }


}
