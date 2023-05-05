package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // open a scanner for input
        Map<String, Integer> values;
        int n = input.nextInt(); // create an int n
        input.nextLine();
        List<String> inputs = new ArrayList<>(); // open a list to add words into it

        for (int count = 0; count < n; count++) { // add mas many words as defined from int n
            String myword = input.nextLine();
            inputs.add(myword); // adding my words to a list called inputs
            calculateScore(myword);
        }
        inputs.sort((word1, word2) -> {     // define a comparator method // representing  method through an expression
            int score1 = calculateScore(word1); //take score for word1
            int score2 = calculateScore(word2); // takes score for word
            if (score1 != score2) {   // if the score1 is not = to score 2 it will compare and sort by score
                return Integer.compare(score1, score2); // merge sort
            }
            return word1.compareTo(word2); // else it sorts by alpha
        });

        for (int i = 0; i < inputs.size(); i++) {

            System.out.println(inputs.get(i));

            //var word = inputs.get(i);
            // System.out.println(word +" " + calculateScore(word));
        }
    }

    public static int calculateScore(String myword) {

        Map<String, Integer> values = new HashMap<>(); // creating a hash map with values containing string letters and integers numbers to be matched

        values.put("a", 1);
        values.put("b", 3);
        values.put("c", 3);
        values.put("d", 2);
        values.put("e", 1);
        values.put("f", 4);
        values.put("g", 2);
        values.put("h", 4);
        values.put("i", 1);
        values.put("j", 8);
        values.put("k", 5);
        values.put("l", 1);
        values.put("m", 3);
        values.put("n", 1);
        values.put("o", 1);
        values.put("p", 3);
        values.put("q", 10);
        values.put("r", 1);
        values.put("s", 1);
        values.put("t", 1);
        values.put("u", 1);
        values.put("v", 4);
        values.put("w", 4);
        values.put("x", 8);
        values.put("y", 4);
        values.put("z", 10);


        char[] mystring = myword.toCharArray();   // declaring an array called numberArr which converts my numberStr variable to singular char in array
        int totalscore=0;
        for (int i = mystring.length - 1; i >= 0; i--) {    // for loop to iterate through my charcater array


            String valueToConvert = String.valueOf(mystring[i]); // Create a variable called valuetoConvert which collects strings from numberArr
            int convert = values.get(valueToConvert);    // variable digit collects converted chars from get function in Hah map
            totalscore += convert;
        }
        return totalscore;
    }

}