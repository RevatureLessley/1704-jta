package com.revature.topic;

import java.util.Scanner;

public class FizzBuzz {

    // Data field
    private int num;
    private String numbersString;
    private boolean flag;
    Scanner input = new Scanner(System.in);

    // Setters and Getters

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNumbersString() {
        return numbersString;
    }

    public void setNumbersString(String numbersString) {
        this.numbersString = numbersString;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    // Class methods

    public String isFizzBuzz(int num) {
        String result = Integer.toString(num);
        if (num % 3 == 0) {
            result = "Fizz";
        } else if (num % 5 == 0) {
            result = "Buzz";
        } else if ( num % 3 == 0 && num % 5 == 0 ) {
            result = "FizzBuzz";
        }
        return result;
    }


     public void start(){

        System.out.println("Welcome to the FizzBuzz Example!" +
                "\nThis program will print numbers 1 to 100. " +
                "\nIf a number is divisible by 3, it will be replaced with Fizz" +
                "\nIf a number is divisible by 5, it will be replace with Buzz" +
                "\nPress enter to continue!");


    }

    public static void main(String[] args) {
    }

}
