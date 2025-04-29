package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private static String fileName = "transactions.csv";

    public static List<Transaction> loadTransactions() throws FileNotFoundException {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    Transaction transaction = Transaction.fromCSV(line);
                    transactions.add(transaction);
                } catch (Exception e) {
                }
            }
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return transactions;
}}
