package com.pluralsight;

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
                    break;

                case "2":
                    break;

                case "3":
                    break;

                case "4":
                    break;

                case "5":
                    System.out.print("Enter vendor name to search: ");
                    System.out.print("Enter vendor name to search: ");
                    String vendorName = input.nextLine().toLowerCase();
                    for (Transaction t : transactions) {
                        if (t.getVendor().toLowerCase().contains(vendorName)) {
                            System.out.println(t);
                        }else
                            System.out.println("No vendor matching name provided.");
                    }
                    break;

                case "0":
                    return;
            }
        }

    }
}
