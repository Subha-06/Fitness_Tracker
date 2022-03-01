import java.util.Scanner;
import java.util.HashMap;
import java.util.*;

public class Project {
    public static void main(String[] args) {

        //Inputs from user about personal data
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String userName;
        userName = scan.nextLine();
        System.out.println("Enter your age: ");
        Double userAge;
        userAge = scan.nextDouble();
        scan.nextLine();
        System.out.println("Enter your gender (F for female, M for male or N if prefer not to say): ");
        String userGender;
        userGender = scan.nextLine();

        //Inputs for fitness tracking
        System.out.println("Enter your weight: ");
        Double userWeight;
        userWeight = scan.nextDouble();
        System.out.println("Enter your height: ");
        Double userHeight;
        userHeight = scan.nextDouble();

        ArrayList<Double> userInfo = new ArrayList<Double>();
        userInfo.add(userAge); userInfo.add(userWeight); userInfo.add(userHeight);

        HashMap<String, ArrayList> map = new HashMap<>();
        map.put(userName, userInfo);


        outMenu(userName, userAge, userGender,userWeight, userHeight);

    }

    public static int outMenu(String userName, Double userAge, String userGender, Double userWeight, Double userHeight) {
        int checkinput;
        do {
            System.out.println("""
                    Menu:
                    Press 1: Check the user information
                    Press 2: Check BMI of the user
                    Press 3: Check the weight status of user according to BMI
                    Press 4: Estimate how much calories need to burn to reach certain BMI
                    Press 5: Estimate how many hours needed to exercise to reach a goal
                    Press 0: To exit the program
                    """);
            Scanner input = new Scanner(System.in);
            checkinput = input.nextInt();
            if (checkinput == 1){
                input.nextLine();
                System.out.println("Do you want to change your inputs: (Press Y to change or N to view)");
                String userinput;
                userinput = input.nextLine();
                while (userinput.equals("Y") || userinput.equals("y") || userinput.equals("yes")){

                    System.out.println("Enter your name: ");
                    userName = input.nextLine();
                    System.out.println("Enter your age: ");
                    userAge = input.nextDouble();
                    System.out.println("Enter your gender: ");
                    userGender = input.nextLine();
                    System.out.println("Enter your weight: ");
                    userWeight = input.nextDouble();
                    System.out.println("Enter your height: ");
                    userHeight = input.nextDouble();
                    input.nextLine();
                    System.out.println("Do you want to change your inputs: (Press Y to change or N to to view)");
                    userinput = input.nextLine();

                }
                HashMap<String, String> userInfo = new HashMap<String, String>();
                userInfo.put("Gender", userGender); userInfo.put("Name",userName);
                System.out.println(userInfo);

                System.out.println("You are " + userName);
                System.out.println("Age:" + userAge);
                System.out.println("Gender:" + userGender);
                System.out.println("Weight:" + userWeight);
                System.out.println("Height:" + userHeight);

            } else if (checkinput == 2){
                double BMI = BMI(userWeight, userHeight);
                System.out.println("Your BMI:" + BMI);

            } else if (checkinput == 3){
                double BMI = BMI(userWeight, userHeight);
                System.out.println(BMI_Compare(BMI));

            } else if (checkinput == 4){
                System.out.print("How much weight in KGs do you want to lose?");
                int kg_input = input.nextInt();

                System.out.println("You need to burn " + estimateCalories(kg_input) + " calories");

            }else if (checkinput == 5){

                System.out.println("Not complete");

            }else{

                System.out.println("Program Exited");
            }


        }while (checkinput == 1 || checkinput == 2 || checkinput == 3 || checkinput == 4 || checkinput == 5);
        return checkinput;


    }

    //Print user info


    //BMI Calculation
    public static double BMI(Double userWeight, Double userHeight){

        double BMI = userWeight/ (userHeight * userHeight);
        return BMI;
    }


    public static String BMI_Compare(Double BMI){

        if(BMI < 18.5){

            return "You are underweight";

        }else if(BMI <= 25){
            return "You are normal weight";

        }else if(BMI <= 29 ){
            return "You are overweight";

        }else
            return "You are obese";

    }

    public static int estimateCalories(int kg_input){

        //Calories needed to burn 1 kg
        final int CALORIES = 7700;


        int total_calories = (kg_input * CALORIES);
        return total_calories;

    }




}