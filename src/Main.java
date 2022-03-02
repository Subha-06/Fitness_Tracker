import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    /**
     * Start the tracking program
     *
     * @param args No arguments expected
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello, This is a fitness tracking program");
        System.out.println("If you want to enter your information press 'Y'" + "To exit the program press anything else");
        String userchoice = input.nextLine();
        if (userchoice.equals("Y") || userchoice.equals("y")) {
            getuserinput();
        } else {
            System.out.println("You choose to exit the program.");
            System.exit(0);
        }
    }

    /**
     * Get information from user and add them to a hashmap
     */

    public static void getuserinput() {

        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your name:");
        String name;
        name = input.nextLine();
        System.out.println("Please Enter your Gender:");
        String gender;
        gender = input.nextLine();
        System.out.println("Please enter your age:");
        double age;
        age = input.nextInt();
        System.out.println("Please Enter your weight in Kilograms:");
        double weight;
        weight = input.nextDouble();
        System.out.println("Please Enter your height in meters:");
        double height;
        height = input.nextDouble();


        //Add the user information to an arraylist then add that arraylist to hashmap with the name as the key

        ArrayList<Double> userinfo = new ArrayList<>();
        userinfo.add(age);
        userinfo.add(weight);
        userinfo.add(height);


        HashMap<String, ArrayList> userinfo2 = new HashMap<>();

        //
        userinfo2.put(name, userinfo);
        getuserchoice(name, gender, userinfo2);
    }


    /**
     * Outputs the menu and allows the user to choose what to do
     *
     * @param name     The name the user input
     * @param userinfo The hashmap with the users information
     */

    public static void getuserchoice(String name, String gender, HashMap<String, ArrayList> userinfo) {
        int userinput;
        double age = (double) userinfo.get(name).get(0);
        double weight = (double) userinfo.get(name).get(1);
        double height = (double) userinfo.get(name).get(2);


        do {
            System.out.println("""
                                        
                                        
                                        
                    Menu:
                    Press 1: View user information
                    Press 2: Change input
                    Press 3: Check BMI of the user
                    Press 4: Check the weight status of user according to BMI
                    Press 5: Estimate how much calories need to burn to reach a certain weight.
                    Press 6: Estimate how many hours needed to exercise to reach a goal
                    Press 0: To exit the program
                                        
                                        
                                        
                    """);
            Scanner input = new Scanner(System.in);
            userinput = input.nextInt();
            if (userinput == 1) {
                printinfo(name, gender, age, weight, height);
            } else if (userinput == 2) {
                input.nextLine();
                System.out.println("Do you want to change your inputs: (Press Y to change)");
                String checkinput;
                checkinput = input.nextLine();
                reenter();


            } else if (userinput == 3) {
                String bmi = bmi(weight, height);
                System.out.println(bmi);
            } else if (userinput == 4) {


            } else if (userinput == 5) {

            } else if (userinput == 6) {

            } else if (userinput == 7) {
                System.out.println("You choose to exit the program.");
                System.exit(0);
            }
        } while (userinput == 1 || userinput == 2 || userinput == 3 || userinput == 4);
    }

    /**
     * @param name   The name of the user
     * @param gender The gender of the user
     * @param age    The age of the user
     * @param weight The weight of the user
     * @param height The height of the user
     */
    public static void printinfo(String name, String gender, double age, double weight, double height) {

        System.out.println("You are " + name);
        System.out.println("Your weight is " + weight + "kg.");
        System.out.println("Gender: " + gender);
        System.out.println("Your age is " + age + " years");
        System.out.println("You are " + height + " meters tall");
    }

    /**
     * @param
     */
    public static void reenter() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your name:");
        String name;
        name = input.nextLine();
        System.out.println("Please Enter your Gender");
        String gender;
        gender = input.nextLine();
        System.out.println("Please enter your age:");
        double age;
        age = input.nextInt();
        System.out.println("Please Enter your weight in Kilograms:");
        double weight;
        weight = input.nextDouble();
        System.out.println("Please Enter your height in meters:");
        double height;
        height = input.nextDouble();

        //Add the user information to an arraylist then add that arraylist to hashmap with the name as the key

        ArrayList<Double> userinfo = new ArrayList<>();
        userinfo.add(age);
        userinfo.add(weight);
        userinfo.add(height);


        HashMap<String, ArrayList> userinfo2 = new HashMap<>();
        userinfo2.put(name, userinfo);
        getuserchoice(name, gender, userinfo2);


    }

    /**
     * Calculates the BMI of the user and returns it in a formatted to a two decimal point.
     *
     * @param weight The weight of the user
     * @param height The height of the user
     * @return The BMI in formatted to two decimal points
     */

    public static String bmi(double weight, double height) {
        double calculatedBMI = weight / (height * height);
        return String.format("%.02f", calculatedBMI);

    }

    /**
     * @param bmi
     * @return
     */
    public static String bmicompare(double bmi) {
        if (bmi < 18.5) return "You are thin";
        else if (bmi < 25) return "You are normal";
        else if (bmi < 30) return "You are overweight";
        else return "You are obese";

    }

    /**
     * @return
     */
    public static int estimateCalories() {
        Scanner input = new Scanner(System.in);
        System.out.print("How much weight in KGs do you want to lose or gain?");
        int kg_input = input.nextInt();

        //Calories needed to burn 1 kg
        final int CALORIES = 7000;


        return (kg_input * CALORIES);

    }

    /**
     * @param total_calories
     * @param userWeight
     */

    public static void estimateExercise(int total_calories, double userWeight) {
        Scanner input = new Scanner(System.in);
        System.out.print("""
                Which type of exercise do you want to do?
                A. Cycling
                B. Running
                """);
        String userinput;
        userinput = input.nextLine();
        if (userinput.equals("A")) {

            //MET constant value for cycling
            int[] array = {6, 8, 10}; //Order respective to the options below

            System.out.println("You have chosen to do cycling");
            System.out.println("""
                    Select the speed of cycling:
                    1. 16-19 km/h
                    2. 19-22 km/h
                    3. 22-25 km/h
                    """);
            int checkoption;
            checkoption = input.nextInt();
            if (checkoption == 1) {

                double ex_burnt = (total_calories * 200) / (array[0] * userWeight * 3.5 * 60);
                System.out.printf("You need to exercise %.1f hours to burn %d calories%n", ex_burnt, total_calories);


            } else if (checkoption == 2) {

                double ex_burnt = (total_calories * 200) / (array[1] * userWeight * 3.5 * 60);
                System.out.printf("You need to exercise %.1f hours to burn %d calories%n", ex_burnt, total_calories);

            } else if (checkoption == 3) {

                double ex_burnt = (total_calories * 200) / (array[2] * userWeight * 3.5 * 60);
                System.out.printf("You need to exercise %.1f hours to burn %d calories%n", ex_burnt, total_calories);

            }

        } else if (userinput.equals("B")) {

            //MET constant value for running
            int[] array2 = {5, 8, 11}; //Order respective to the options below

            System.out.println("You have chosen to do running");
            System.out.println("""
                    Select the speed of cycling:
                    1. 6-7 km/h
                    2. 7-8 km/h
                    3. 9-11 km/h
                    """);
            int checkoption;
            checkoption = input.nextInt();
            if (checkoption == 1) {

                double ex_burnt = (total_calories * 200) / (array2[0] * userWeight * 3.5 * 60);
                System.out.printf("You need to exercise %.1f hours to burn %d calories%n", ex_burnt, total_calories);

            } else if (checkoption == 2) {

                double ex_burnt = (total_calories * 200) / (array2[1] * userWeight * 3.5 * 60);
                System.out.printf("You need to exercise %.1f hours to burn %d calories%n", ex_burnt, total_calories);

            } else if (checkoption == 3) {

                double ex_burnt = (total_calories * 200) / (array2[2] * userWeight * 3.5 * 60);
                System.out.printf("You need to exercise %.1f hours to burn %d calories%n", ex_burnt, total_calories);

            }

        } else {

            System.out.println("Program Exited");
        }
    }

}


