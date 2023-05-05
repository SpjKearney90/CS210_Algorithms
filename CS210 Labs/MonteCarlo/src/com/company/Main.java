package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String args[]) {
        int simulations = 1000 ;
        int x = 2;
        int[] student = new int[20];
        int[]count = new int[simulations];
        int total = 0 ;

        int num = 0 ;


        for(int i =0 ; i<simulations; i++){
            count[i] = isbirthday(student);
        }
        for(int j =0 ; j<count.length; j++){
            total = count[j]+total;
            if(count[j]==x) num++;
        }
        int probability = (num *100)/ total;
        System.out.println(probability);


    }
    public static int isbirthday(int[] student) {
        Random day = new Random();
        for (int i = 0; i < student.length; i++) {
            student[i] = day.nextInt(364) + 1; // starts at 0 // + 1  brings it to 365 !
        }
        //Arrays.stream(student)
        // .distinct().// don't have matches
        // .toArray(); // converting into a stream // loops through array and removes duplicates .

        int[]distinctstudent = Arrays.stream(student).distinct().toArray(); // this creates new array with the removal of duplicates ( Functional Java )
        return student.length - distinctstudent.length; // size of original array against new created array !







        //  for (int j = 0; j < student.length; j++) {
        //    for (int k = j + 1; k < student.length; k++) {
        //        if (student[j] == student[k]) {
        //           count++;// number of times matched in the array
        //      }

        //    }

        //  }
        //   return count;
    }
}


