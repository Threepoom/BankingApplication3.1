package BankingApplication3;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class BankingApplication3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int option = 0,accountNumber;
        String accountName,accountType;
        double balance,amount,minimum = 1000;
        Account account = null;
        Bank bank = new Bank("GasiGorn");


        while (option != 6){
            System.out.println("Main Menu");
            System.out.println("1.Display All Account");
            System.out.println("2.Open New Account");
            System.out.println("3.Close Existing Account");
            System.out.println("4.Deposit");
            System.out.println("5.Withdraw");
            System.out.println("6.Exit");
            System.out.println();

            System.out.print("Enter your choice: ");
            option = s.nextInt();
            s.nextLine();
            System.out.println();

            switch (option){
                case 1:
                    bank.listAccounts();
                    break;
                case 2:
                    accountNumber = generateAccountNumber();
                    System.out.print("Enter Account Name: ");
                    accountName = s.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    balance = s.nextDouble();
                    s.nextLine();
                    System.out.print("Enter account (s --> SavingAcc or c --> CurrentAcc): ");
                    accountType = s.nextLine();
                    if (accountType.toLowerCase().equals("s")){
                        account = new SavingAccount(accountNumber, accountName, balance);
                    }
                    else if(accountType.toLowerCase().equals("c")){
                        account = new CurrentAccount(accountNumber,accountName,balance);
                    }
                   // account = new Account( number, name, balance);
                    bank.openAccount(account);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accountNumber = s.nextInt();
                    s.nextLine();
                    System.out.print("Enter account (s --> SavingAcc or c --> CurrentAcc): ");
                    accountType = s.nextLine();
                    if (accountType.toLowerCase().equals("s")){
                        account = bank.getAccount(accountNumber,"SavingAccount");
                    }
                    else if(accountType.toLowerCase().equals("c")){
                        account = bank.getAccount(accountNumber,"CurrentAccount");
                    }
                    bank.closeAccount(account);
                    System.out.println("Account has been deleted!");
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    accountNumber = s.nextInt();
                    s.nextLine();
                    System.out.print("Enter account (s --> SavingAcc or c --> CurrentAcc): ");
                    accountType = s.nextLine();
                    if (accountType.toLowerCase().equals("s")){
                        account = bank.getAccount(accountNumber,"SavingAccount");
                    }
                    else if(accountType.toLowerCase().equals("c")){
                        account = bank.getAccount(accountNumber,"CurrentAccount");
                    }
                    System.out.print("Enter Amount: ");
                    amount = s.nextDouble();
                    bank.depositMoney(account,amount);
                    System.out.println("Deposit success: " + "+ " + amount);
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Enter Account Number: ");
                    accountNumber = s.nextInt();
                    s.nextLine();
                    System.out.print("Enter account (s --> SavingAcc or c --> CurrentAcc): ");
                    accountType = s.nextLine();
                    if (accountType.toLowerCase().equals("s")){
                        account = bank.getAccount(accountNumber,"SavingAccount");
                    }
                    else if(accountType.toLowerCase().equals("c")){
                        account = bank.getAccount(accountNumber,"CurrentAccount");
                    }
                    System.out.print("Enter Amount: ");
                    amount = s.nextDouble();
                    bank.withDrawMoney(account,amount);
                    System.out.println("Withdraw success: " + "- "+ amount);
                    System.out.println();
                    break;
            }

        }
    }
    public  static int generateAccountNumber(){
        Random random = new Random();
        int accNumber = 100000 + random.nextInt(900000);
        return accNumber;
    }
}