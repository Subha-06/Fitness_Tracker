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

import static Main.Calculations.*;
import static Main.Calculations.getTotalCalories;
import static Main.Main.*;


public final class Menu {

    /**
     * Getting the users information and storing it.
     */

    public static User getUserInput(int flag) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your name:");
        String name;
        name = scanner.nextLine();
        String gender = getInputGender();
        //Get user age,height,weight and make sure they are valid numbers
        double age = getInputAge();
        double weight = getInputWeight();
        double height = getInputHeight();
        User user = null;

        //A flag is used to check if the user is entering the information manually or from a file
        //If user enters information from a file then the information will be stored in object type arraylist for individual user subclass
        if (flag != 0) {
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
            //If user enters information manually then the information will be stored in Hashmaps to be accessed later
        } else {
            Main.userInfo1.put("Name: ", name);
            Main.userInfo1.put("Gender: ", gender);
            Main.userInfo2.put("Age: ", age);
            Main.userInfo2.put("Weight: ", weight);
            Main.userInfo2.put("Height: ", height);
        }
        return user;
    }

    /**
     * @param user
     * @param inputFlag This Flag determines which information to access (0 for manual, 1 for file read)
     */

    public static void getUserChoice(User user, int inputFlag) throws IOException {
        int userinput;

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
                    Press 8: Calculate Total calories lost
                    Press 9: Calculate the highest number of calories lost in a day
                    Press 0: To exit the program
                    """);
            Scanner input = new Scanner(System.in);
            userinput = input.nextInt();
            //If the user to check the info entered.
            if (userinput == 1) {
                if (inputFlag == 0) {
                    Main.printInfo(userInfo1, userInfo2);
                } else if (inputFlag == 1) {
                    try {
                        System.out.println(femaleList.toString().replace("[", "").replace("]", ""));
                        System.out.println(maleList.toString().replace("[", "").replace("]", ""));
                        System.out.println(nUserList.toString().replace("[", "").replace("]", ""));
                    } catch (NullPointerException e) {
                        System.err.println("No information is found!");
                    }
                }
            }
            //If the user wants to re-enter the information.
            else if (userinput == 2) {
                input.nextLine();
                if (inputFlag == 0) {
                    //A flag is used to determine which information the user wants to edit
                    int flag = 0;
                    getUserChoice(getUserInput(flag), 0);
                } else if (inputFlag == 1) {
                    //A flag is used to determine which information the user wants to edit
                    int flag = 1;
                    getUserChoice(getUserInput(flag), 1);
                }
            }
            //If the user wants to know their BMI
            else if (userinput == 3) {
                //Checking if the user object is null
                int choice;
                if (inputFlag == 0) {
                    double weight = userInfo2.get("Weight: ");
                    double height = userInfo2.get("Height: ");

                    String bmi = bmi(weight, height);
                    System.out.println("Your BMI is " + bmi);
                } else if (inputFlag == 1) {
                    System.out.println("Which user you want to calculate for?('1' for User 1, '2' for User 2, '3' for User 3)");
                    choice = input.nextInt();

                    if (user == null) {
                        System.err.println("No User found");
                    } else {
                        if (choice == 1) {
                            double weight = femaleList.get(0).getUserWeight();
                            double height = femaleList.get(0).getUserHeight();

                            String bmi = bmi(weight, height);
                            System.out.println("Your BMI is " + bmi);

                        } else if (choice == 2) {
                            double weight = maleList.get(0).getUserWeight();
                            double height = maleList.get(0).getUserHeight();

                            String bmi = bmi(weight, height);
                            System.out.println("Your BMI is " + bmi);

                        } else if (choice == 3) {
                            double weight = nUserList.get(0).getUserWeight();
                            double height = nUserList.get(0).getUserHeight();

                            String bmi = bmi(weight, height);
                            System.out.println("Your BMI is " + bmi);
                        }
                    }
                }
            }
            //If the user wants to check their BMI.
            else if (userinput == 4) {
                int choice;
                System.out.println("Which user BMI do you want to compare?('1' for manual input user or '2' for file read users)");
                choice = input.nextInt();
                if (inputFlag == 0) {
                    double weight = userInfo2.get("Weight: ");
                    double height = userInfo2.get("Height: ");

                    System.out.println(bmiCompare(weight, height));

                } else if (inputFlag == 1) {
                    System.out.println("Which user you want to compare for?('1' for User 1, '2' for User 2, '3' for User 3)");
                    choice = input.nextInt();

                    if (user == null) {
                        System.err.println("No User found");
                    } else {
                        if (choice == 1) {
                            double weight = femaleList.get(0).getUserWeight();
                            double height = femaleList.get(0).getUserHeight();

                            System.out.println(bmiCompare(weight, height));

                        } else if (choice == 2) {
                            double weight = maleList.get(0).getUserWeight();
                            double height = maleList.get(0).getUserHeight();

                            System.out.println(bmiCompare(weight, height));

                        } else if (choice == 3) {
                            double weight = nUserList.get(0).getUserWeight();
                            double height = nUserList.get(0).getUserHeight();

                            System.out.println(bmiCompare(weight, height));
                        }
                    }
                }
            }
            //If the user wants to know how much calorie they need to burn to reach a certain weight
            else if (userinput == 5) {
                System.out.println("How much weight in Kgs do you want to lose?");
                int kg_input = input.nextInt();
                System.out.println("You need to burn " + estimateCalories(kg_input) + " calories");

                //If the user wants to know how many calories they need to burn to lose certain amount of weight
            } else if (userinput == 6) {
                System.out.println("How much weight in Kgs do you want to lose?");
                int kg_input = input.nextInt();
                int choice;
                if (inputFlag == 0) {
                    double weight = userInfo2.get("Weight: ");

                    int total_calories = estimateCalories(kg_input);
                    estimateExercise(total_calories, weight, kg_input);

                } else if (inputFlag == 1) {
                    System.out.println("Which user you want to compare for?('1' for User 1, '2' for User 2, '3' for User 3)");
                    choice = input.nextInt();

                    if (user == null) {
                        System.err.println("No User found");
                    } else {
                        if (choice == 1) {
                            double weight = femaleList.get(0).getUserWeight();

                            int total_calories = estimateCalories(kg_input);
                            estimateExercise(total_calories, weight, kg_input);

                        } else if (choice == 2) {
                            double weight = maleList.get(0).getUserWeight();

                            int total_calories = estimateCalories(kg_input);
                            estimateExercise(total_calories, weight, kg_input);

                        } else if (choice == 3) {
                            double weight = nUserList.get(0).getUserWeight();

                            int total_calories = estimateCalories(kg_input);
                            estimateExercise(total_calories, weight, kg_input);
                        }
                    }
                }
                //If the user wants to save how many calories they burnt each day
            } else if (userinput == 7) {
                System.out.println("How much calories you have burnt today?");
                int cal_burnt = input.nextInt();

                Util.Writer.writer(cal_burnt);

                //If the user wants to know the total amount of calories burnt till now
            } else if (userinput == 8) {

                ArrayList<String> cal = new ArrayList<>(Reader.outReader());
                if (cal.isEmpty()) {
                    System.err.println("File is empty!");
                } else {
                    int total = getTotalCalories(cal);
                    System.out.println("Total calories lost: " + total);
                }
            } else if (userinput == 9) {
                ArrayList<String> cal = new ArrayList<>(Reader.outReader());
                if (cal.isEmpty()) {
                    System.err.println("File is empty!");
                } else {
                    getMaxCalories(cal);
                }
            }
            //Exit the program
            else if (userinput == 0) {
                System.err.println("You choose to exit the program.");
            }
        } while (userinput == 1 || userinput == 2 || userinput == 3 || userinput == 4 || userinput == 5 || userinput == 6 || userinput == 7 || userinput == 8 || userinput == 9);
    }

    /**
     * Making sure the gender is one of the three options
     *
     * @return returns a string of the gender
     */


    public static String getInputGender() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Please Enter your Gender:
                (F for Female, M for Male or N if preferred not to say):
                """);
        String gender = scanner.nextLine();
        if (Objects.equals(gender, "n") || Objects.equals(gender, "N")) {
            gender = "N";
            return gender;
        } else if (Objects.equals(gender, "m") || Objects.equals(gender, "M")) {
            gender = "M";
            return gender;
        } else if (Objects.equals(gender, "f") || Objects.equals(gender, "F")) {
            gender = "F";
            return gender;
        } else {
            System.out.println("Please enter F,M or N");
            gender = getInputGender();
        }
        return gender;
    }

    /**
     * This function makes sure the user inputs a valid number because age has to be over 0.
     *
     * @return returns the age of the user
     */

    public static double getInputAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your age:");
        double age = scanner.nextDouble();
        //If the age is less than or equals to zero ask the user for input again.
        if (age < 0 || age == 0) {
            System.out.println("The input is not valid, height cannot be a negative number or zero");
            age = getInputAge();
        }
        return age;
    }


    /**
     * This function makes sure the user inputs a valid number because weight has to be over 0.
     *
     * @return returns the weight of the user
     */

    public static double getInputWeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your weight in Kilograms:");
        double weight = scanner.nextDouble();
        //If the weight is less than or equals to zero ask the user for input again.
        if (weight < 0 || weight == 0) {
            System.out.println("The input is not valid, height cannot be a negative number or zero");
            weight = getInputWeight();
        }
        return weight;
    }

    /**
     * This function makes sure the user inputs a valid number because height has to be over 0.
     *
     * @return returns the height of the user
     */


    public static double getInputHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your height in centimeters:");
        double height = scanner.nextDouble();
        //If the height is less than or equals to zero ask the user for input again.
        if (height < 0 || height == 0) {
            System.out.println("The input is not valid, height cannot be a negative number or zero");
            height = getInputHeight();
        }
        return height;
    }
}
