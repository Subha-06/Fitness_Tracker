/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 1 March 2022
 * * Demo 2 Tutorial 05
 */
package Util;


import java.io.*;
import java.util.*;
import java.util.Scanner;

import Main.*;
import Util.*;


public final class Menu {
    //Creating a scanner

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Getting the users information and storing it in a hashmap.
     */

    public static void getUserInput() {

        System.out.println("Please Enter your name:");
        String name;
        name = scanner.nextLine();
        System.out.println("Enter your age: ");
        double age;
        age = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Please Enter your Gender (F for Female, M for Male or N if preferred not to say):");
        String gender;
        gender = scanner.nextLine();
        System.out.println("Enter your weight in kilograms: ");
        double weight;
        weight = scanner.nextDouble();
        System.out.println("Enter your height in meters: ");
        double height;
        height = scanner.nextDouble();

        User user = new User();

        user.setUserName(name);
        user.setUserGender(gender);
        user.setUserAge(age);
        user.setUserWeight(weight);
        user.setUserHeight(height);

        Main.getUserChoice(user);
    }

}
