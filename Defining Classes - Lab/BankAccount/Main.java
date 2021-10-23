package BankAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        BankAccounts bank = new BankAccounts();

        while (!command.equals("End")) {
            String[] commandArgs = command.split("\\s+");

            switch (commandArgs[0]) {
                case "Create":
                    bank.addNewBankAccount(new BankAccount());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(commandArgs[1]);
                    int deposit = Integer.parseInt(commandArgs[2]);

                    if(bank.isExist(id)) {
                        BankAccount b = bank.getUser(id);
                        b.deposit(deposit);
                        bank.setUser(b);
                    }
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(commandArgs[1]));
                    break;
                case "GetInterest":
                    id = Integer.parseInt(commandArgs[1]);
                    int years = Integer.parseInt(commandArgs[2]);
                    if (bank.isExist(id)) {
                        double interest = bank.getUser(id).getInterest(years);
                        System.out.printf("%.2f%n", interest);
                    }
                    break;
            }

            command = sc.nextLine();
        }
    }
}
