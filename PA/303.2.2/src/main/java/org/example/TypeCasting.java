package org.example;

public class TypeCasting {

    public static void main(String[] args) {

      int x = 20;
      double y = 40.5;
      long p = 30;
      float q = 10.60f;
      byte b = 42;
      char c = 'a';
      short s = 1024;
      int i = 50000;
      float f = 5.67f;
      double d = .1234;


      //int z = x + y; (1) // error; cannot convert from double to int.
        double z = x + y;
        System.out.println("Sum of two number: " + z);

        //Long r = p -q; // (2) // Error; cannot convert from float to long.
        float r = p - q;
        System.out.println("Subtraction of two numbers: " + r);

        double result = (f * b) + (i / c) - (d * s);

        //Result after all the promotions are done
        System.out.println("result = " + result);

    }


}
