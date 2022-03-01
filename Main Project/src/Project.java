import java.time.Year;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;


public class Project {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to this fitness tracking program");
        System.out.println("If you want to enter your information press 'Y' or to exit the program press 'N'");
        String userchoice = input.nextLine();
        if (userchoice.equals("Y")) {
            getUserInfo();
        }else{
            System.out.println("Program Exited");
        }

    }

    public static void getUserInfo (){
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
        System.out.println("Enter your height in centimeters: ");
        double userHeight;
        userHeight = scan.nextDouble();

        //Storing the data
        ArrayList<Double> userInfo = new ArrayList<>();
        userInfo.add(userAge);
        userInfo.add(userWeight);
        userInfo.add(userHeight);
        HashMap<String, ArrayList> userInfo2 = new HashMap<>();
        userInfo2.put(userName, userInfo);
        outMenu(userName, userGender, userAge, userWeight, userHeight, userInfo2);


    }

    public static int outMenu(String userName, String userGender, double userAge, double userWeight, double userHeight, HashMap<String, ArrayList> userInfo2){
        int checkinput;
        do {
            System.out.println("""
                    Menu:
                    Press 1: Check the user information
                    Press 2: Change user information
                    Press 3: Check BMI of the user
                    Press 4: Check the weight status of user according to BMI
                    Press 5: Estimate how much calories need to burn to reach certain BMI
                    Press 6: Estimate how many hours needed to exercise to reach a goal
                    Press 0: To exit the program
                    """);
            Scanner input = new Scanner(System.in);
            checkinput = input.nextInt();
            if (checkinput == 1){
                printUserInfo(userName, userGender, userAge, userWeight, userHeight,userInfo2);

            } else if (checkinput == 2){
                input.nextLine();
                System.out.println("Do you want to change your inputs: (Press Y to change or N to return to menu)");
                String userinput;
                userinput = input.nextLine();
                inputChange(userinput);

            } else if (checkinput == 3){
                double BMI = BMI(userWeight, userHeight);
                System.out.println(String.format("Your BMI: %.2f", BMI));

            } else if (checkinput == 4){
                double BMI = BMI(userWeight, userHeight);
                System.out.println(BMI_Compare(BMI));

            }else if (checkinput == 5){

                System.out.println("You need to burn " + estimateCalories() + " calories");

            }else if (checkinput == 6){

                System.out.println("Not complete");

            }else{

                System.out.println("Program Exited");
            }


        }while (checkinput == 1 || checkinput == 2 || checkinput == 3 || checkinput == 4 || checkinput == 5 || checkinput == 6);
        return checkinput;

    }



    public static void printUserInfo(String userName, String userGender, double userAge, double userWeight, double userHeight, HashMap<String, ArrayList> userInfo2){
        userInfo2.get(1);

        System.out.println("You are " + userName);
        System.out.println("Your weight is " + userWeight + " kg");
        System.out.println("Gender:" + userGender);
        System.out.println("Your age is " + userAge + " years");
        System.out.println("You are " + userHeight + " centimeters tall");

    }

    public static void inputChange(String checkinput){
        Scanner input = new Scanner(System.in);


        while (checkinput.equals("Y") || checkinput.equals("y") || checkinput.equals("yes")) {
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
            System.out.println("Please Enter your height in centimeters: ");
            double userHeight;
            userHeight = input.nextDouble();
            System.out.println("Do you want to change your inputs: (Press Y to change or N to return to menu)");
            checkinput = input.nextLine();
            ArrayList<Double> userInfo = new ArrayList<Double>();
            userInfo.add(userAge);
            userInfo.add(userWeight);
            userInfo.add(userHeight);
            HashMap<String, ArrayList> userInfo2 = new HashMap<>();
            userInfo2.put(userName, userInfo);
            outMenu(userName, userGender, userAge, userWeight, userHeight, userInfo2);

        }

    }

    public static double BMI(double userWeight, double userHeight){
        //cm square to meter square conversion constant
        final int CONVERT = 10000;

        double BMI = (userWeight/ (userHeight * userHeight) * CONVERT);
        return BMI;
    }

    public static String BMI_Compare(double BMI){

        if(BMI < 18.5){

            return "You are underweight";

        }else if(BMI <= 25){
            return "You are normal weight";

        }else if(BMI <= 29 ){
            return "You are overweight";

        }else
            return "You are obese";
    }

    public static int estimateCalories(){

        //Calories needed to burn 1 kg
        Scanner input =  new Scanner(System.in);
        System.out.print("How much weight in KGs do you want to lose?");
        int kg_input = input.nextInt();

        //Calories needed to burn 1 kg
        final int CALORIES = 7700;


        int total_calories = (kg_input * CALORIES);
        return total_calories;
    }

    public static void estimateExercise(){

    }






}
