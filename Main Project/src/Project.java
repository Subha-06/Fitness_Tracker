import java.util.Scanner;
import java.math.*;
import java.util.*;
import java.util.HashMap;

public class Project {
    public static void main(String[] args) {

        //Inputs from user about personal data
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String userName;
        userName = scan.nextLine();
        System.out.println("Enter your age: ");
        String userAge;
        userAge = scan.nextLine();
        System.out.println("Enter your gender (F for female, M for male or N if prefer not to say): ");
        String userGender;
        userGender = scan.nextLine();

        //Inputs for fitness tracking
        System.out.println("Enter your weight: ");
        double userWeight;
        userWeight = scan.nextDouble();
        System.out.println("Enter your height: ");
        double userHeight;
        userHeight = scan.nextDouble();

        scan.nextLine();
        System.out.println("Do you want to change your inputs: (Press Y to change or N to view)");
        String checkinput;
        checkinput = scan.nextLine();
        while(checkinput.equals("Y") || checkinput.equals("y") || checkinput.equals("yes")){

            System.out.println("Enter your name: ");
            userName = scan.nextLine();
            System.out.println("Enter your age: ");
            userAge = scan.nextLine();
            System.out.println("Enter your gender: ");
            userGender = scan.nextLine();
            System.out.println("Enter your weight: ");
            userWeight = scan.nextDouble();
            System.out.println("Enter your height: ");
            userHeight = scan.nextDouble();
            scan.nextLine();
            System.out.println("Do you want to change your inputs: (Press Y to change or N to to view)");
            checkinput = scan.nextLine();
        }

        HashMap<String, String> userInfo = new HashMap<String, String>();
        userInfo.put("Gender", userGender); userInfo.put("Name",userName);
        System.out.println(userInfo);

        System.out.println("You are " + userName);
        System.out.println("Age:" + userAge);
        System.out.println("Gender:" + userGender);
        System.out.println("Weight:" + userWeight);
        System.out.println("Height:" + userHeight);
        double BMI = BMI(userWeight, userHeight);
        System.out.println("Your BMI:" + BMI);
        System.out.println(BMI_Compare(BMI));
    }

        //BMI Calculation
        public static double BMI(double userWeight, double userHeight){

            double BMI = userWeight/ (userHeight * userHeight);
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























    }














