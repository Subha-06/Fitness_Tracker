/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 1 March 2022
 * * Demo 2 Tutorial 05
 */
package Main;

import Util.Reader;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static Main.Calculations.*;
import static Util.Menu.*;

public class Main {

    public static ArrayList<User> nUserList = new ArrayList<>();
    public static ArrayList<User> femaleList = new ArrayList<>();
    public static ArrayList<User> maleList = new ArrayList<>();

    /**
     * Start the tracking program
     *
     * @param args No arguments expected
     */
    public static void main(String[] args) throws IOException {
        //Getting file names
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, This is a fitness tracking program");
        System.out.println("""
                If you want to enter your information press '1'
                If you want to enter your information from a file press '2'
                """);
        String userchoice = scanner.nextLine();
        if (userchoice.equals("1")) {
            getUserInput();

        }
        if (userchoice.equals("2")) {
            if (args.length != 0) {
                File fileInput = new File(args[0]);
                if (fileInput.exists() && fileInput.canRead()) {
                    getUserChoice(Reader.reader(fileInput));
                }
            } else {
                System.err.println("File Not Found!");
            }
        } else {
            System.out.println("You choose to exit the program.");
            System.exit(0);
        }
    }

    /**
     * Outputs the menu and allows the user to choose what to do
     *
     * @param user The user object
     */

    public static void getUserChoice(User user) throws IOException {
        int userinput;

        double weight = user.getUserWeight();
        double height = user.getUserHeight();


        //A do-while loop to keep printing the menu until the user exits the program.
        do {
            System.out.println("""
                                        
                                        
                                        
                    Menu:
                    Press 1: View user information
                    Press 2: Change input
                    Press 3: Check BMI of the user
                    Press 4: Check the weight status of user according to BMI
                    Press 5: Estimate how much calories need to burn to reach a certain weight.
                    Press 6: Estimate how many hours needed to exercise to reach a certain weight.
                    Press 7: Add how much calories you have burnt daily
                    Press 0: To exit the program
                    """);
            Scanner input = new Scanner(System.in);
            userinput = input.nextInt();
            //If the user to check the info entered.
            if (userinput == 1) {

                System.out.println(femaleList.toString());
                System.out.println(maleList.toString());
                System.out.println(nUserList.toString());

            }

            //If the user wants to re-enter the information call the re-enter function.
            else if (userinput == 2) {
                input.nextLine();
                user = getUserInput();
                getUserChoice(user);
            }
            //If the user wants to know their BMI
            else if (userinput == 3) {
                String bmi = bmi(weight, height);
                System.out.println("Your BMI is " + bmi);
            }
            //If the user wants to check their BMI.
            else if (userinput == 4) {
                System.out.println(bmicompare(weight, height));

            }
            //If the user wants to know how much calorie they need to burn to reach a certain weight
            else if (userinput == 5) {
                System.out.println("How much weight in Kgs do you want to lose?");
                int kg_input = input.nextInt();
                System.out.println("You need to burn " + estimateCalories(kg_input) + " calories");


            } else if (userinput == 6) {
                System.out.println("How much weight in Kgs do you want to lose?");
                int kg_input = input.nextInt();
                int total_calories = estimateCalories(kg_input);
                estimateExercise(total_calories, weight, kg_input);

            } else if (userinput == 7) {
                System.out.println("How much calories you have burnt today?");
                int cal_burnt = input.nextInt();

                Util.Writer.writer(cal_burnt);

            }
            //Exit the program
            else if (userinput == 8) {
                System.out.println("You choose to exit the program.");
                System.exit(0);
            }
        }

        while (userinput == 1 || userinput == 2 || userinput == 3 || userinput == 4 || userinput == 5 || userinput == 6 || userinput == 7);
    }

    /**
     * Prints the user information
     *
     * @param name   The name of the user
     * @param gender The gender of the user
     * @param age    The age of the user
     * @param weight The weight of the user
     * @param height The height of the user
     */

//    private static void printInfo(String name, String gender, double age, double weight, double height) {
//        System.out.println("You are " + name);
//        System.out.println("Your weight is " + weight + "kg.");
//        System.out.println("Gender: " + gender);
//        System.out.println("Your age is " + age + " years");
//        System.out.println("You are " + height + " centimeters tall");
//    }

}


