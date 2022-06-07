package com.oohanmu;

import java.util.Scanner;

public class Main {

    static boolean menu = true;
    static boolean menu2 = true;
    static int option2;
    static Account account = new Account();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (menu) {
            System.out.println("1. Create an account");
            System.out.println("2. Log into account");
            System.out.println("0. Exit");

            int menuOption = scanner.nextInt();

            if (menuOption == 1) {
                createAccount();
            } else if (menuOption == 2) {
                loginAccount();
            } else if (menuOption == 0) {
                exitAccount();
            }
        }
    }

    private static void createAccount() {

        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        System.out.println(account.generateCard());

        account.generatePin();
        System.out.println("Your card PIN:");
        System.out.println(account.getPin());

    }

    private static void loginAccount() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your card number:");
        String numberInput = scanner.nextLine();

        System.out.println("Enter your PIN:");
        String pinInput = scanner.nextLine();

        if (!(account.getCard().equals(numberInput) && account.getPin().equals(pinInput))) {
            System.out.println("Wrong card number or PIN!");

        } else {
            System.out.println("You have successfully logged in!");

            while (menu2) {
                String create = "1. Balance";
                System.out.println(create);

                String login = "2. Log out";
                System.out.println(login);

                String exit = "0. Exit";
                System.out.println(exit);

                System.out.println();

                option2 = scanner.nextInt();

                if (option2 == 1) {
                    Account.balance();
                } else if (option2 == 2) {
                    logOutAccount();
                } else if (option2 == 0) {
                    exitAccount();
                }
            }
        }
    }

    private static void logOutAccount() {
        System.out.println("You have successfully logged out!");

        menu2 = false;
    }

    private static void exitAccount() {
        System.out.println("Bye!");

        menu = false;
    }
}

