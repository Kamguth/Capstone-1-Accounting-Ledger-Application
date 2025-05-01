package com.pluralsight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reports {
    public static void displayReportMenu(List<Transaction> transactions) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nReports Menu:");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");
            System.out.print("Choose an option: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    LocalDate now = LocalDate.now();
                    List<Transaction> mtd = new ArrayList<>();//create new list to filter transactions this month
                    for (Transaction t : transactions) {
                        LocalDate date = t.getTimestamp().toLocalDate();
                        //if year and month of a transaction = current year and month
                        if (date.getYear() == now.getYear() && date.getMonth() == now.getMonth()) {
                            mtd.add(t);
                        }
                    }
                    Ledger.displayTransactions(mtd);//displays formated array of mtd transactions
                    break;


                case "2":
                    break;

                case "3":
                    int currentYear = LocalDate.now().getYear();
                    List<Transaction> ytd = new ArrayList<>();//creates new array to filter transactions from this year to
                    for (Transaction t : transactions) {
                        //if timestamped year is the same as current year
                        if (t.getTimestamp().getYear() == currentYear) {
                            ytd.add(t);
                        }
                    }
                    Ledger.displayTransactions(ytd);//displays formated array of ytd transactions
                    break;

                case "4":
                    //last year = current year minus 1
                    int lastYear = LocalDate.now().getYear() -1;
                    List<Transaction> previousYear = new ArrayList<>();
                    for (Transaction t :transactions) {
                        if (t.getTimestamp().getYear() == lastYear) {
                            previousYear.add(t);
                        }
                    }
                    Ledger.displayTransactions(previousYear);
                    break;

                case "5":
                    System.out.print("Enter vendor name to search: ");
                    System.out.print("Enter vendor name to search: ");
                    String vendorName = input.nextLine().toLowerCase();
                    for (Transaction t : transactions) {
                        if (t.getVendor().toLowerCase().contains(vendorName)) {
                            System.out.println(t);
                        }
                    }
                    break;

                case "0":
                    return;
            }
        }

    }
}
