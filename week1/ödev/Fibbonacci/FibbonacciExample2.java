/**
 * 
 * @author Guray Kaleli,2021
 * 
 * @return calculation of fibonacci number and order them
 * 
 * */

package com.week1.ödev.fibbonacci;

import java.util.Scanner;

public class FibbonacciExample2 {

    // identify a method for fibbonacci number and take number as parameter 
    public static int fibbonacci(int number){

            if (number <= 1){
                return number;
            }

            /*
                this is recursive method. When number is more than 1 method will add number to the next number
                and continue by adding
             */

           return fibbonacci(number - 1) + fibbonacci(number - 2);
    }

    public static void main(String[] args) {

        // object from scanner class to get input from user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your fibbonacci number : ");
        int fib = scanner.nextInt();

        // call fibbonacci method inside a for-loop and put "i" in method and use as a our method parameter
        for (int i = 0; i < fib; i++){
            System.out.print(fibbonacci(i) + " ");
        }

        scanner.close();
    }

}
