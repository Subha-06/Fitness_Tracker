import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *         A fitness tracking program that allows the user to input their information and get back various results form that
 *         *Members:
 *         Fabiha Fairuzz Subha (UCID: 30148674)
 *         Amasil Rahim Zihad (UCID: 30164830)
 *         * Date: 1 March, 2022
 *         * Demo 1 Tutorial 10
 */

public class Project {
    /**
     * Start the tracking program
     *
     * @param args No arguments expected
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to this fitness tracking program");
        System.out.println("If you want to enter your information press 'Y' or to exit the program press 'N'");
        String userchoice = input.nextLine();
        if (userchoice.equals("Y")) {
            getUserInfo();
        } else {
            System.out.println("You choose to exit the program.");
            System.exit(0);
        }
    }

    /**
     * Function to get the user info
     */
    public static void getUserInfo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String userName;
        userName = scan.nextLine();
        System.out.println("Enter your age: ");
        double userAge;
        userAge = scan.nextDouble();
        scan.nextLine();
        System.out.println("Enter your gender (F for female, M for male or N if prefer not to say): ");
        String userGender;
        userGender = scan.nextLine();
        System.out.println("Enter your weight in kilograms: ");
        double userWeight;
        userWeight = scan.nextDouble();
        System.out.println("Enter your height in meters: ");
        double userHeight;
        userHeight = scan.nextDouble();

        //Storing the data
        ArrayList<Double> userInfo = new ArrayList<>();
        userInfo.add(userAge);
        userInfo.add(userWeight);
        userInfo.add(userHeight);
        //Including the array in a hashmap and assigning the key to be the name of the user
        HashMap<String, ArrayList> userInfo2 = new HashMap<>();
        userInfo2.put(userName, userInfo);
        //Calls menu after getting user input
        outMenu(userName, userGender, userInfo2);

    }

    /**
     *
     * @param userName The name of the user
     * @param userGender The gender of the user
     * @param userInfo2 The hashmap where the user information are stored
     */
    public static void outMenu(String userName, String userGender, HashMap<String, ArrayList> userInfo2) {
        int checkinput;
        // We know that the first element of the arraylist that is passed in as a value of hashmap here is the age
        //The second element is weight
        //The third element is height
        // Here we are extracting this information from the hashmap and casting as double so that we can pass them as
        // parameters for other functions.
        double userAge = (double) userInfo2.get(userName).get(0);
        double userWeight = (double) userInfo2.get(userName).get(1);
        double userHeight = (double) userInfo2.get(userName).get(2);

        do {
            System.out.println("""
                    
                    
                    
                    Menu:
                    Press 1: Check the user information
                    Press 2: Change user information
                    Press 3: Check BMI of the user
                    Press 4: Check the weight status of user according to BMI
                    Press 5: Estimate how much calories need to burn to lose certain amount of weight
                    Press 6: Estimate how many hours needed to exercise to reach a goal
                    Press 0: To exit the program
                    """);
            Scanner input = new Scanner(System.in);
            checkinput = input.nextInt();
            if (checkinput == 1) {
                //Calling the print user info function to print all the information
                printUserInfo(userName, userGender, userAge, userWeight, userHeight);

            } else if (checkinput == 2) {
                input.nextLine();
                //Calling the change input function to enable the user to re-enter the details
                inputChange();

            } else if (checkinput == 3) {
                //Calculating and printing out BMI using BMI function
                String BMI = BMI(userWeight, userHeight);
                System.out.println("Your BMI: " + BMI);

            } else if (checkinput == 4) {
                //Comparing and printing out the statement using BMI_compare function
                String BMI = BMI(userWeight, userHeight);
                System.out.println(BMI_Compare(BMI));

            } else if (checkinput == 5) {
                //Calculating the total calories need to burn according the user input using estimateCalories function
                System.out.print("How much weight in Kgs do you want to lose?");
                int kg_input = input.nextInt();
                System.out.println("You need to burn " + estimateCalories(kg_input) + " calories");

            } else if (checkinput == 6) {
                //Calculating the total number of hours needed to exercise using the estimateExercise function
                System.out.print("How much weight in Kgs do you want to lose?");
                int kg_input = input.nextInt();
                int total_calories = estimateCalories(kg_input);
                estimateExercise(total_calories, userWeight);

            } else if (checkinput == 0) {
                //Program should exit if the user input matches 0 or anything else that is not defined in the menu
                System.out.println("You choose to exit the program.");
                System.exit(0);

            }


        } while (checkinput == 1 || checkinput == 2 || checkinput == 3 || checkinput == 4 || checkinput == 5 || checkinput == 6);
    }

    /**
     *
     * @param userName The name of the user
     * @param userGender The gender of the user
     * @param userAge The age of the user
     * @param userWeight The weight of the user
     * @param userHeight The height of the user
     *
     */
    public static void printUserInfo(String userName, String userGender, double userAge, double userWeight, double userHeight) {

        //Printing out the user information
        System.out.println("You are " + userName);
        System.out.println("Your weight is " + userWeight + " kg");
        System.out.println("Gender:" + userGender);
        System.out.println("Your age is " + userAge + " years");
        System.out.println("You are " + userHeight + " meters tall");
    }


    /**
     * Function to enable user to re-enter data
     */
    public static void inputChange() {
        Scanner input = new Scanner(System.in);

        System.out.println("Please Enter your name: ");
        String userName;
        userName = input.nextLine();
        System.out.println("Please Enter your gender (F for female, M for male or N if prefer not to say):: ");
        String userGender;
        userGender = input.nextLine();
        System.out.println("Please enter your age: ");
        double userAge;
        userAge = input.nextInt();
        System.out.println("Please Enter your weight in Kilograms: ");
        double userWeight;
        userWeight = input.nextDouble();
        System.out.println("Please Enter your height in meters: ");
        double userHeight;
        userHeight = input.nextDouble();


        //Storing the newly entered data to update the Array and HashMap
        ArrayList<Double> userInfo = new ArrayList<Double>();
        userInfo.add(userAge);
        userInfo.add(userWeight);
        userInfo.add(userHeight);

        HashMap<String, ArrayList> userInfo2 = new HashMap<>();
        userInfo2.put(userName, userInfo);
        outMenu(userName, userGender, userInfo2);
    }


    /**
     *
     * @param userWeight The weight of the user
     * @param userHeight The height of the user
     * @return The calculated BMI of the user
     */
    public static String BMI(double userWeight, double userHeight) {

        double BMI = userWeight / (userHeight * userHeight);

        String sBMI = String.format("%.2f", BMI);
        return sBMI;
    }

    /**
     *
     * @param sBMI The calculated BMI of the user
     * @return A string to give the user weight status
     */
    public static String BMI_Compare(String sBMI) {

        double dBMI = Double.parseDouble(sBMI);

        if (dBMI < 18.5) {

            return "You are underweight";

        } else if (dBMI <= 25) {
            return "You are normal weight";

        } else if (dBMI <= 29) {
            return "You are overweight";

        } else
            return "You are obese";
    }

    /**
     *
     * @return Total number of calories needed to burn to lose the user inputted weight
     */
    public static int estimateCalories(int kg_input) {

        //Calories needed to burn 1 kg
        final int CALORIES = 7700;


        int total_calories = (kg_input * CALORIES);
        return total_calories;
    }

    /**
     *
     * @param total_calories Total number of calories needed to burn to lose the user inputted weight
     * @param userWeight The weight of the user
     */
    public static void estimateExercise(int total_calories, double userWeight) {
        Scanner input = new Scanner(System.in);
        //Giving the user to chose the type of exercise they want to do
        System.out.println("""
                Which type of exercise do you want to do?
                A. Cycling
                B. Running
                """);
        String userinput;
        userinput = input.nextLine();
        if (userinput.equals("A") || userinput.equals("a")) {

            //MET constant value for cycling
            int[] array = {6, 8, 10}; //Order respective to the options below

            //Number of hours of exercise will depend on the speed of the exercise due to MET value
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
                System.out.println(String.format("You need to exercise %.1f hours at 16-19 km/h to burn %d calories", ex_burnt, total_calories));

            } else if (checkoption == 2) {

                double ex_burnt = (total_calories * 200) / (array[1] * userWeight * 3.5 * 60);
                System.out.println(String.format("You need to exercise %.1f hours at 19-22 km/h to burn %d calories", ex_burnt, total_calories));

            } else if (checkoption == 3) {

                double ex_burnt = (total_calories * 200) / (array[2] * userWeight * 3.5 * 60);
                System.out.println(String.format("You need to exercise %.1f hours at 22-25 km/h to burn %d calories", ex_burnt, total_calories));

            }

        } else if (userinput.equals("B") || userinput.equals("b")) {

            //MET constant value for running
            int[] array2 = {5, 8, 11}; //Order respective to the options below

            //Number of hours of exercise will depend on the speed of the exercise due to MET value
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
                System.out.println(String.format("You need to exercise %.1f hours at 6-7 km/h to burn %d calories", ex_burnt, total_calories));

            } else if (checkoption == 2) {

                double ex_burnt = (total_calories * 200) / (array2[1] * userWeight * 3.5 * 60);
                System.out.println(String.format("You need to exercise %.1f hours at 7-8 km/h to burn %d calories", ex_burnt, total_calories));

            } else if (checkoption == 3) {

                double ex_burnt = (total_calories * 200) / (array2[2] * userWeight * 3.5 * 60);
                System.out.println(String.format("You need to exercise %.1f hours at 9-11 km/h to burn %d calories", ex_burnt, total_calories));

            }

        } else {
            //If anything other than the inputs defined in menu is pressed, program will exit
            System.out.println("Program Exited");
        }
    }


}