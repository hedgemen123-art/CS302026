package wealthsimulator;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class FinanceApp {

    private static ArrayList<Investment> portfolio = new ArrayList<>();
    private static final String FILE_NAME = "investments.txt";

    public static void main(String[] args) {

        loadFromFile();

        Scanner input = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {

            System.out.println("\n==== Personal Wealth Simulator ====");
            System.out.println("1. Add Investment");
            System.out.println("2. View Portfolio");
            System.out.println("3. Save & Exit");
            System.out.print("Select option: ");

            choice = input.nextInt();
            input.nextLine(); // clear buffer

            if (choice == 1) {
                addInvestment(input);
            }
            else if (choice == 2) {
                viewPortfolio();
            }
            else if (choice == 3) {
                saveToFile();
                System.out.println("Data saved. Program closed.");
            }
            else {
                System.out.println("Invalid option.");
            }
        }

        input.close();
    }

    private static void addInvestment(Scanner input) {

        System.out.print("Enter investment name: ");
        String name = input.nextLine();

        System.out.print("Enter principal amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter annual interest rate (ex: 6 for 6%): ");
        double ratePercent = input.nextDouble();

        System.out.print("Enter term in years: ");
        int term = input.nextInt();
        input.nextLine();

        double rateDecimal = ratePercent / 100.0;

        Investment inv = new Investment(name, principal, rateDecimal, term);
        portfolio.add(inv);

        System.out.println("Investment added.");
    }

    private static void viewPortfolio() {

        if (portfolio.isEmpty()) {
            System.out.println("No investments available.");
            return;
        }

        double total = 0;

        for (Investment inv : portfolio) {
            System.out.println(inv.displayInfo());
            total += inv.calculateBalance();
        }

        System.out.println("Total Projected Wealth: $" + String.format("%.2f", total));
    }

    private static void saveToFile() {

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME));

            for (Investment inv : portfolio) {
                writer.println(inv.toString());
            }

            writer.close();
        }
        catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    private static void loadFromFile() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                String name = parts[0];
                double principal = Double.parseDouble(parts[1]);
                double rate = Double.parseDouble(parts[2]);
                int term = Integer.parseInt(parts[3]);

                portfolio.add(new Investment(name, principal, rate, term));
            }

            reader.close();
        }
        catch (IOException e) {
            // First run, file may not exist yet
        }
    }
}
