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

    /**
     * Getting the users information and storing it in a hashmap.
     */

    public static User getUserInput() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your name:");
        String name;
        name = scanner.nextLine();
        System.out.println("Please Enter your Gender (F for Female, M for Male or N if preferred not to say):");
        String gender;
        gender = scanner.nextLine();
        //Get user age,height,weight and make sure they are valid numbers
        double age = getInputAge();
        double weight = getInputWeight();
        double height = getInputHeight();

        User user = null;
        int userinput;
        System.out.println("Which user did you give information for? ('1' for User 1, '2' for User 2, '3' for User 3): ");
        userinput = scanner.nextInt();

        if (userinput == 1) {

            user = new Female(name, gender, age, weight, height);
            Main.femaleList.set(0, user);

        } else if (userinput == 2) {

            user = new Male(name, gender, age, weight, height);
            Main.maleList.set(0, user);

        } else if (userinput == 3) {

            user = new NGender(name, gender, age, weight, height);
            Main.nUserList.set(0, user);

        }
        return user;
        //Main.getUserChoice(user);
    }

    /**
     * This function makes sure the user inputs a valid number because age has to be over 0.
     *
     * @return returns the age of the user
     */

    public static double getInputAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your age:");
        double userAge = scanner.nextDouble();
        //If the age is less than or equals to zero ask the user for input again.
        if (userAge < 0 || userAge == 0) {
            System.out.println("The input is not valid, height cannot be a negative number or zero");
            userAge = getInputAge();
        }
        return userAge;
    }

    /**
     * This function makes sure the user inputs a valid number because weight has to be over 0.
     *
     * @return returns the weight of the user
     */

    public static double getInputWeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your weight in Kilograms:");
        double userWeight = scanner.nextDouble();
        //If the weight is less than or equals to zero ask the user for input again.
        if (userWeight < 0 || userWeight == 0) {
            System.out.println("The input is not valid, height cannot be a negative number or zero");
            userWeight = getInputWeight();
        }
        return userWeight;
    }

    /**
     * This function makes sure the user inputs a valid number because height has to be over 0.
     *
     * @return returns the height of the user
     */


    public static double getInputHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your height in centimeters:");
        double userHeight = scanner.nextDouble();
        //If the height is less than or equals to zero ask the user for input again.
        if (userHeight < 0 || userHeight == 0) {
            System.out.println("The input is not valid, height cannot be a negative number or zero");
            userHeight = getInputHeight();
        }
        return userHeight;
    }


}
