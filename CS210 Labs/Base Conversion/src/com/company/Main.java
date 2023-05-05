package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        int fromBase = input.nextInt();
        int toBase = input.nextInt();
        input.close();

        long decimalValue = converttoDecimal(number, fromBase);

        System.out.println(convertBase(decimalValue, toBase));
    }

    public static long converttoDecimal(String numberStr, int fromBase) {

        Map<String, Integer> values = new HashMap<>(); // creating a hash map with values containing string letters and integers numbers to be matched

        values.put("0", 0);
        values.put("1", 1);
        values.put("2", 2);
        values.put("3", 3);
        values.put("4", 4);
        values.put("5", 5);
        values.put("6", 6);
        values.put("7", 7);
        values.put("8", 8);
        values.put("9", 9);
        values.put("a", 10);
        values.put("b", 11);
        values.put("c", 12);
        values.put("d", 13);
        values.put("e", 14);
        values.put("f", 15);
        values.put("g", 16);
        values.put("h", 17);
        values.put("i", 18);
        values.put("j", 19);
        values.put("k", 20);
        values.put("l", 21);
        values.put("m", 22);
        values.put("n", 23);
        values.put("o", 24);
        values.put("p", 25);
        values.put("q", 26);
        values.put("r", 27);
        values.put("s", 28);
        values.put("t", 29);
        values.put("u", 30);
        values.put("v", 31);
        values.put("w", 32);
        values.put("x", 33);
        values.put("y", 34);
        values.put("z", 35);

        char[] numberArr = numberStr.toCharArray();   // declaring an array called numberArr which converts my numberStr variable to singular char in array

        long totalDecimal = 0;
        int pow = 0;

        for (int i = numberArr.length - 1; i >= 0; i--) {    // for loop to iterate through my charcater array

            String valueToConvert = String.valueOf(numberArr[i]); // Create a variable called valuetoConvert which collects strings from numberArr
            int digit = values.get(valueToConvert);    // variable digit collects converted chars from get function in Hah map

            double decimal = digit * Math.pow(fromBase, pow);

            totalDecimal = totalDecimal + (long) decimal;

            pow++; // decimal variable takes collected deciamls and multiples them to get conversion
        }

        return totalDecimal;
    }

    public static String convertBase(long decimal, int toBase) {


        char[] values = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        StringBuilder result =    new StringBuilder();  // string builder that hold characxter from char array 
        
        while (decimal != 0) {

            long value = decimal % toBase != 0 ? decimal % toBase : 0;
            decimal = decimal / toBase;

            try {
                result.append(values[(int) value]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return result.reverse().toString();
    }
}
