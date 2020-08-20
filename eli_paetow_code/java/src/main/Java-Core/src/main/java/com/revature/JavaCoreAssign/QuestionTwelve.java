package com.revature.JavaCoreAssign;


import java.util.ArrayList;
import java.util.Arrays;

//Write a program to store numbers from 1 to 100 in an array.
// Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the number
public class QuestionTwelve {

    public static int[] evenArrayQ12(int arrayNum) {

        /**
         *set up int array for evens
         * set up array list to hold
         * */

        int[] evenArray = new int[arrayNum];
        ArrayList<Integer> holdNumsArray = new ArrayList<>();
        int count = 0;

        for (int i = 1; i < evenArray.length + 1; i++) {
            evenArray[i - 1] = i;
        }
        System.out.println("--------------------------------");
        System.out.println("stored numbers");

        System.out.println(Arrays.toString(evenArray));

        System.out.println("--------------------------------");
        System.out.println("question 12 evens!!!");


        //adavanced FOR loop
        /**
         *move through the array index.
         * subtract by one. check the if remainder = to 0
         *
         * */
        for (int i : evenArray) {
            if (evenArray[i - 1] % 2 == 0) {
                count++;
                holdNumsArray.add(evenArray[i - 1]);
            }
        }
        int[] numOfEvens = new int[count];

        /**
         *return new num of even arrays
         * */
        for (int i = 0; i < count; i++) {
            numOfEvens[i] = holdNumsArray.get(i);
            System.out.println(numOfEvens[i] + " ");
        }
        return numOfEvens;
    }

    public static void main(String[] args) {
        evenArrayQ12(100);
    }

}
