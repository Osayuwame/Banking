package com.oohanmu;

import java.util.Random;

public class Account {

    private static String card;
    private String pin;
    private final Random random = new Random();

    public Account() {}

    public String getCard() { return card; }

    public String getPin() { return pin; }

    public String generateCard() {
        card = "400000";

        String card2 = String.format("%05d", random.nextInt(100000));
        String card3 = String.format("%05d", random.nextInt(100000));

        card += card2;
        card += card3;

        boolean res = cardCheck(card);

        if (res) {
            card = card;
        } else {
            generateCard();
        }
        return card;
    }

    public void generatePin() {
        pin = String.format("%04d", random.nextInt(10000));
    }

    public static void balance() {
        int bal = 0;

        System.out.println("Balance: " +bal);
    }

    public static boolean cardCheck(String ccNumber)
    {
        int sum = 0;
        boolean alternate = false;
        for (int i = ccNumber.length() - 1; i >= 0; i--)
        {
            int n = Integer.parseInt(ccNumber.substring(i, i + 1));
            if (alternate)
            {
                n *= 2;
                if (n > 9)
                {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

}
