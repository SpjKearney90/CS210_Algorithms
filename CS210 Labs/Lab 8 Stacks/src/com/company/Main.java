package com.company;

import javax.print.attribute.standard.PrinterState;
import java.awt.print.Printable;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // opens a scanner
        // take in direction through scanner
        Scanner input = new Scanner(System.in);
        Stack<String> whichdirection = new Stack<>(); // create a stack called mydirections

        while(true){
            String mydirection = input.nextLine();

            if(!mydirection.equals("arrived")){
                if(mydirection.equals("go back")){
                    whichdirection.pop();
                }else{
                    whichdirection.push(mydirection);
                }
            }
            else break;
        }
        while (!whichdirection.isEmpty()) {
            String homedirection =whichdirection.pop();
            System.out.println(goHome(homedirection)); // Pop ever element , call it against the go home the opposite
        }

    }
    public static String goHome (String home){

        if (home.equals("Go North")) {
            return "Go South";
        } else if
        (home.equals("Go South")) {
            return "Go North";
        } else if
        (home.equals("Go East")) {
            return "Go West";
        } else
            return "Go East";

    }
}





