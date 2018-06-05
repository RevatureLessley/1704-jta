package com.revature.application;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    // Data Field
    private static int num;
    private static String string;
    private static boolean flag;
    private static boolean terminate = false;
    private static Scanner input = new Scanner(System.in);

    // Setters and Getters

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        Menu.num = num;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        Menu.string = string;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        Menu.flag = flag;
    }

    public boolean isTerminate() {
        return terminate;
    }

    public void setTerminate(boolean terminate) {
        Menu.terminate = terminate;
    }

    // Class Methods

    public static void terminateApplication() {
        System.out.println("\nYou are exiting the application..." +
                "\nAre you sure? [Y/N]");
        char answer = input.next().toUpperCase().charAt(0);
        if (answer == 'Y') ;
    }

    public static void pressEnter() {
        System.out.println("\nPress ENTER to return to the Menu.");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getTopic(int num) {
        switch (num) {
            case -1:
                terminateApplication();
                break;
            case 1:
                System.out.println("You chose 1");
                //Palindrome.start();
                pressEnter();
                break;
            case 2:
                System.out.println("You chose 2");
                //ReverseString.start();
                pressEnter();
                break;
            case 3:
                System.out.println("You chose 3");
                //Fibonacci.start();
                pressEnter();
                break;
            case 4:
                System.out.println("You chose 4");
//                FizzBuzz.start();
                pressEnter();
                break;
            case 5:
                System.out.println("You chose 5");
//                Factorial.start();
                pressEnter();
                break;
            default:
                break;
        }
    }

    public static void userMenu() {
        int selection;
        System.out.println("\nThe following are the topic available:\n" +
                "\n 1 - Palindrome" +
                "\n 2 - Reverse String" +
                "\n 3 - Fibonacci" +
                "\n 4 - FizzBuzz" +
                "\n 5 - Factorial" +
                "\n-1 - Exit" +
                "\n\nPlease enter the number of the topic you wish to view:" +
                "\n");
        try {
            if(input.hasNext())
                input.reset();
            selection = Integer.parseInt(input.next());
            // User can only select numbers 0 to 5
            if (selection < -1 || selection > 5 || selection == 0) {
                System.out.println("\nPlease enter an integer from 1 to 5 or -1!");
            } else
                getTopic(selection);
        } catch (NumberFormatException nfe) {
            System.out.println("\nInvalid input! Please enter a number!");
        }
    }

    public static void start() {
        while (!terminate) {
            userMenu();
        }
        input.close();
    }

}
