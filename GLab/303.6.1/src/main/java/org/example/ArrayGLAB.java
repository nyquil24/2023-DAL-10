package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayGLAB {

    public static void main(String[] args) {

        // create an array
        int[] age = {12,4,5};

        //Loop through the arra
        //using for loop

        System.out.println("Using for Loop:");
        for(int i = 0; i < age.length; i++){
            System.out.println(age[i]);

    }

        String[] names = {"New York", "Dallas", "Las Vegas", "Florida"};
        for(String name : names){
            System.out.println(name);
        }

        int[] numbers = {2, -9,0,5,12,-25, 22,9,8,12};
        int sum = 0;
        Double average;

        //access all elements using for each Loop
        // add each element in sum

        for(int number: numbers){
            sum+=number;
        }

        //get the total number of elements
        int arrayLength = numbers.length;

        //calculate the average
        // convert the average from int to double
        average = ((double)sum / (double)arrayLength);

        System.out.println("sum = " + sum);
        System.out.println("Average = " + average);

        int[] marks = {74, 43, 58, 60, 90, 64, 70};
        int sum2 = 0;
        int sumSq = 0;
        double mean, stdDev;

        //Compute sum and square-sum using Loop
        for (int i = 0; i < marks.length; i++){
            sum2 += marks[i];
            sumSq += marks[i] * marks[i];
        }
        mean = (double)sum2 / marks.length;
        stdDev = Math.sqrt((double)sumSq / marks.length - mean * mean);

        // Print results
        System.out.printf("Mean is : %.2f%n", mean);
        System.out.printf("Standard deviation is: %.2f%n", stdDev);

        int se, element;
        int[] arr = new int[11];
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter 10 Elements: ");
        for(se=0; se<10; se++)
            arr[se] = scan.nextInt();

        System.out.println("Enter an Element to Insert: ");
        element = scan.nextInt();
        arr[se] = element;

        System.out.println("\nNow the new array is: ");
        for(se=0; se<11; se++)
            System.out.println(arr[se]+ " ");

    }

}
