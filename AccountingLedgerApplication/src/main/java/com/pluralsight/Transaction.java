package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//instance variables, store transaction details
public class Transaction {
    private LocalDateTime timestamp;
    private String description;
    private String vendor;
    private double amount;


    //constructors, set up new transactions
    public Transaction(LocalDateTime timestamp, String description, String vendor, double amount) {
        this.timestamp = timestamp;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    // Convert a CSV line into a Transaction object
    public static Transaction fromCSV(String line) {
        String[] parts = line.split("\\|");
        LocalDateTime timestamp = LocalDateTime.parse(parts[0] + "T" + parts[1]);
        String description = parts[2];
        String vendor = parts[3];
        double amount = Double.parseDouble(parts[4]);
        return new Transaction(timestamp, description, vendor, amount);
    }

    // Convert a Transaction to a CSV-formatted string
    public String toCSV() {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        return date.format(timestamp) + "|" + time.format(timestamp) + "|" + description + "|" + vendor + "|" + amount;
    }

    // Getters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }

    // Print-friendly version
    @Override
    public String toString() {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        return date.format(timestamp) + "|" + time.format(timestamp) + "|" + description + "|" + vendor + "|" + amount;
    }
}
