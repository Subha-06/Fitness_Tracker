import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello, This is a fitness tracking program");
        System.out.println("If you want to enter your information press 'Y'" + "To exit the program press 'N'");
        String userchoice =
                input.nextLine();
        if (userchoice.equals("Y")) {
            getuserinput();
        }
    }

    /**
     *
     */

    public static void getuserinput() {

        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your name:");
        String name;
        name = input.nextLine();
        System.out.println("Please Enter your Gender");
        String gender;
        gender = input.nextLine();
        System.out.println("Please enter your age as an Integer");
        double age;
        age = input.nextInt();
        System.out.println("Please Enter your weight in Kilograms");
        double weight;
        weight = input.nextDouble();
        System.out.println("Please Enter your height in meters");
        double height;
        height = input.nextDouble();

        ArrayList<Double> userinfo = new ArrayList<>();
        userinfo.add(age);
        userinfo.add(weight);
        userinfo.add(height);
        HashMap<String, ArrayList> userinfo2 = new HashMap<>();
        userinfo2.put(name, userinfo);
        getuserchoice(name, gender, age, weight, height, userinfo2);
        System.out.println(userinfo2);

    }

    /**
     *
     * @param name
     * @param gender
     * @param age
     * @param weight
     * @param height
     * @param userinfo
     * @return
     */

    public static int getuserchoice(String name, String gender, double age, double weight, double height, HashMap<String, ArrayList> userinfo) {
        int userinput;
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
                printinfo(name, gender, age, weight, height, userinfo);
            } else if (userinput == 2) {
                input.nextLine();
                System.out.println("Do you want to change your inputs: (Press Y to change or N to view)");
                String checkinput;
                checkinput = input.nextLine();
                reenter(checkinput);


            } else if (userinput == 3) {
                double bmi = bmi(weight, height);
                System.out.println(bmi);
            } else if (userinput == 4) ;
            {
            }
        } while (userinput == 1 || userinput == 2 || userinput == 3 || userinput == 4);
        return userinput;


    }

    /**
     *
     * @param name
     * @param gender
     * @param age
     * @param weight
     * @param height
     * @param userinfo
     */
    public static void printinfo(String name, String gender, double age, double weight, double height, HashMap<String, ArrayList> userinfo) {
        userinfo.get(1);

        System.out.println("You are " + name);
        System.out.println("Your weight is " + weight + "kg.");
        System.out.println("Gender:" + gender);
        System.out.println("Your age is " + age + "years");
        System.out.println("You are ");
        System.out.println(userinfo);
    }

    /**
     *
     * @param checkinput
     */
    public static void reenter(String checkinput) {
        Scanner input = new Scanner(System.in);


        while (checkinput.equals("Y") || checkinput.equals("y") || checkinput.equals("yes")) {
            System.out.println("Please Enter your name:");
            String name;
            name =
                    input.nextLine();
            System.out.println("Please Enter your Gender");
            String gender;
            gender =
                    input.nextLine();
            System.out.println("Please enter your age as an Integer");
            double age;
            age =
                    input.nextInt();
            System.out.println("Please Enter your weight in Kilograms");
            double weight;
            weight =
                    input.nextDouble();
            System.out.println("Please Enter your height in meters");
            double height;
            height =
                    input.nextDouble();
            System.out.println("Do you want to change your inputs: (Press Y to change or N to view)");
            checkinput = input.nextLine();
            ArrayList<Double> userinfo = new ArrayList<Double>();
            userinfo.add(age);
            userinfo.add(weight);
            userinfo.add(height);
            HashMap<String, ArrayList> userinfo2 = new HashMap<>();
            userinfo2.put(name, userinfo);
            getuserchoice(name, gender, age, weight, height, userinfo2);

        }
    }

    /**
     *
     * @param weight
     * @param height
     * @return
     */

    public static double bmi(double weight, double height) {
        return weight / (height * height);

    }

    /**
     *
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
     *
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
     *
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


