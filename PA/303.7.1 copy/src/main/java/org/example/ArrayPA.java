package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPA {

    public static void main(String[] args) {

//        int[] newArray = new int[]{1,2,3};
//
//        for(int i = 0; i < newArray.length; i++)
//
//        System.out.println(newArray[i]);

//        int[] middle = {13, 5, 7, 68,2};
//        int middleElement = middle[middle.length / 2];
//        System.out.println(middleElement);


//    String[] colors = {"red", "green", "blue","yellow"};
//        System.out.println(colors.length);
//        System.out.println(colors);
//
//        String[] copyColors = colors.clone();
//        System.out.println(copyColors);
//        System.out.println(copyColors.toString());
//        int[] intArray = {5,6,7,8,9};
//
//        System.out.println(intArray[0]);
//        System.out.println(intArray[intArray.length-1]);
//        System.out.println(intArray[intArray.length]);


//        int[] task5 = new int[5];
//
//        for(int i = 0; i < task5.length; i++){
//            System.out.println(task5[i]);
//            task5[i] = i;
//        }
//
//        for(int i=0; i < task5.length; i++){
//            System.out.println(task5[i]);
//            System.out.println("array[" + i + "] = " + task5[i]);
//        }
//
//        int[] timesTwo = new int[5];
//
//        for(int i = 0; i < timesTwo.length; i++){
//            timesTwo[i] = i * 2;
//        }
//
//        for(int i = 0; i < timesTwo.length; i++){
//            System.out.println("array[" + i + "] = " + timesTwo[i]);
//        }

//        int[] skipDos = {5,9,7,3,1};
//
//        for(int i = 0; i < skipDos.length; i++){
//            if(i == 2 ){
//                continue;
//            }else{
//                System.out.println(skipDos[i]);
//            }

        String[] swap = {"Hello","this","is","an","array"};


        String temp = swap[0];
        swap[0] = swap[swap.length /2];
        swap[swap.length / 2] = temp;

        for(String swaps: swap){
            System.out.println(swaps);
        }


    }





    }


