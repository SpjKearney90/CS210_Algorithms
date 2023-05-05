package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        public static String baseConversion (String number,int sourceBase, int targetBase){
            var sourceNumberInBase = new BigInteger(number, sourceBase);
            return sourceNumberInBase.toString(targetBase);
        }
    }