package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculations {
    //Constants

    //Calories needed to burn 1 kg
    final static int CALORIES = 7700;

    //Conversion from cm square to meter square
    final static int CONVERSION = 10000;

    /**
     * Calculates the BMI of the user and returns it in a formatted to a two decimal point.
     *
     * @param weight The weight of the user
     * @param height The height of the user
     * @return The BMI in formatted to two decimal points
     */

    public static String bmi(double weight, double height) {
        double calculatedBMI = weight * CONVERSION / (height * height);
        return String.format("%.02f", calculatedBMI);

    }

    /**
     * Compares the bmi of the user and checks the weight status
     *
     * @param weight The weight of the user
     * @param height The height of the user
     * @return Returns the result of comparison as a string
     */
    public static String bmicompare(double weight, double height) {
        double bmi = weight * CONVERSION / (height * height);
        if (bmi < 18.5) return "You are underweight";
        else if (bmi < 25) return "You are normal";
        else if (bmi < 30) return "You are overweight";
        else return "You are obese";

    }

    /**
     * Calculates the estimated calories needed to reach a certain goal
     *
     * @param kg_input The kg amount entered by the user
     * @return Returns the estimated calories needed
     */

    public static int estimateCalories(int kg_input) {
        return (kg_input * CALORIES);
    }


    /**
     * Calculates how much exercise the user needs to do to reach a certain goal
     *
     * @param total_calories Total number of calories needed to burn to lose the user inputted weight
     * @param weight         The weight of the user
     */

    public static void estimateExercise(int total_calories, double weight, int kg_input) {
        Scanner input = new Scanner(System.in);
        //Giving the user to choose the type of exercise they want to do
        System.out.println("""
                Which type of exercise do you want to do?
                A. Cycling
                B. Running
                """);
        String userinput;
        userinput = input.nextLine();
        if (userinput.equals("A")) {

            //MET constant value for cycling
            //Met are constant values, so we just assign them to an array.
            //Formula from omni calculator https://www.omnicalculator.com/sports/calories-burned-biking
            //https://www.bing.com/images/search?view=detailV2&ccid=yadDUQDJ&id=87120523BFFA7EC2BB481F4F72EA93EEF131C32A&thid=OIP.yadDUQDJzCrTGscl7VKGxwHaER&mediaurl=https%3a%2f%2fwww.researchgate.net%2fprofile%2fPongpisit_Wuttidittachotti%2fpublication%2f269927658%2ffigure%2fdownload%2ftbl2%2fAS%3a668512750161926%401536397268552%2fExamples-of-MET-values-for-cycling-jogging-and-walking.png&cdnurl=https%3a%2f%2fth.bing.com%2fth%2fid%2fR.c9a7435100c9cc2ad31ac725ed5286c7%3frik%3dKsMx8e6T6nJPHw%26pid%3dImgRaw%26r%3d0&exph=491&expw=850&q=cycling+met+chart&simid=608045430922565507&FORM=IRPRST&ck=9961DBCB589AF095617EC992BB417D2E&selectedIndex=0&idpp=overlayview&ajaxhist=0&ajaxserp=0
            int[] array = {6, 8, 10}; //Order respective to the options below

            System.out.println("You have chosen to do cycling");
            //Number of hours of exercise will depend on the speed of the exercise due to MET value
            System.out.println("""
                    Select the speed of cycling:
                    1. 16-19 km/h
                    2. 19-22 km/h
                    3. 22-25 km/h
                    """);
            int checkoption;
            checkoption = input.nextInt();
            if (checkoption == 1) {

                double ex_burnt = (total_calories * 200) / (array[0] * weight * 3.5 * 60);
                System.out.printf("You need to cycle %.1f hours at 16-19 km/h to burn %d calories and lose %d kgs", ex_burnt, total_calories, kg_input);


            } else if (checkoption == 2) {

                double ex_burnt = (total_calories * 200) / (array[1] * weight * 3.5 * 60);
                System.out.printf("You need to cycle %.1f hours at 19-22 km/h to burn %d calories and lose %d kgs", ex_burnt, total_calories, kg_input);

            } else if (checkoption == 3) {

                double ex_burnt = (total_calories * 200) / (array[2] * weight * 3.5 * 60);
                System.out.printf("You need to cycle %.1f hours at 22-25 km/h to burn %d calories and lose %d kgs", ex_burnt, total_calories, kg_input);

            }

        } else if (userinput.equals("B")) {

            //MET constant value for running
            //Met are constant values, so we just assign them to an array.
            //Formula from omni calculator https://www.omnicalculator.com/sports/calories-burned-biking
            //https://www.bing.com/images/search?view=detailV2&ccid=yadDUQDJ&id=87120523BFFA7EC2BB481F4F72EA93EEF131C32A&thid=OIP.yadDUQDJzCrTGscl7VKGxwHaER&mediaurl=https%3a%2f%2fwww.researchgate.net%2fprofile%2fPongpisit_Wuttidittachotti%2fpublication%2f269927658%2ffigure%2fdownload%2ftbl2%2fAS%3a668512750161926%401536397268552%2fExamples-of-MET-values-for-cycling-jogging-and-walking.png&cdnurl=https%3a%2f%2fth.bing.com%2fth%2fid%2fR.c9a7435100c9cc2ad31ac725ed5286c7%3frik%3dKsMx8e6T6nJPHw%26pid%3dImgRaw%26r%3d0&exph=491&expw=850&q=cycling+met+chart&simid=608045430922565507&FORM=IRPRST&ck=9961DBCB589AF095617EC992BB417D2E&selectedIndex=0&idpp=overlayview&ajaxhist=0&ajaxserp=0

            int[] array2 = {5, 8, 11}; //Order respective to the options below
            System.out.println("You have chosen running");
            //Number of hours of exercise will depend on the speed of the exercise due to MET value
            System.out.println("""
                    Select the speed of running:
                    1. 6-7 km/h
                    2. 7-8 km/h
                    3. 9-11 km/h
                    """);
            int checkoption;
            checkoption = input.nextInt();
            if (checkoption == 1) {

                double ex_burnt = (total_calories * 200) / (array2[0] * weight * 3.5 * 60);
                System.out.printf("You need to run %.1f hours at 6-7 km/h to burn %d calories and lose %d kgs", ex_burnt, total_calories, kg_input);

            } else if (checkoption == 2) {

                double ex_burnt = (total_calories * 200) / (array2[1] * weight * 3.5 * 60);
                System.out.printf("You need to run %.1f hours at 7-8 km/h to burn %d calories and lose %d kgs", ex_burnt, total_calories, kg_input);

            } else if (checkoption == 3) {

                double ex_burnt = (total_calories * 200) / (array2[2] * weight * 3.5 * 60);
                System.out.printf("You need to run %.1f hours at 9-11 km/h to burn %d calories and lose %d kgs", ex_burnt, total_calories, kg_input);
            }
        }
        //If anything other than the inputs defined in menu is pressed, program will exit
        else {
            System.out.println("You choose to exit the program.");
            System.exit(0);
        }
    }

    /**
     *
     * @param calInfo The arraylist containing the data read from the saved file
     * @return Number of total calories burnt
     */
    public static int getTotalCalories(ArrayList<String> calInfo){

        int sum = 0;
        ArrayList<Integer> calories = new ArrayList<>();
        for (String s : calInfo) {

            try {
                    calories.add(Integer.parseInt(s));

            } catch (NumberFormatException nfe) {
                System.err.println("Cannot convert string to integer type");
            }

        }
        for (int i: calories){

            sum = sum + i;
        }
        return sum;
    }
}
