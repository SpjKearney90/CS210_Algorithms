package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[] creditCard = new int[16];                 // declaring an array to store  10 numbers

        for (int i = 0; i < creditCard.length; i++) {
            creditCard[i] = input.nextInt();
        }
        input.close();

        boolean answer = luhns(creditCard);

        if (answer == true) {
            System.out.println("Valid");
        } else
            System.out.println("Invalid");

    }

    public static boolean luhns(int[] creditCard) {


        int total = 0;

        for (int j = creditCard.length - 2; j >= 0; j -= 2) {
            int backward = creditCard[j] * 2;
            if (backward > 9) {
                backward = backward % 10 + 1;
            }
            creditCard[j] = backward;
            System.out.println(backward);
        }
        for (int backward = 0; backward < creditCard.length; backward++) {
            total += creditCard[backward];
            System.out.println(total);

        }
        if (total % 10 == 0) {
            return true;
        } else
            return false;
    }
}












