import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your name:");
        String name ;
        name = input.nextLine();
        System.out.println("Please enter your age as an Integer");
        int age;
        age = input.nextInt();
        System.out.println("Please Enter your Gender");
        String gender;
        gender = input.nextLine();
        System.out.println("Please Enter your weight in Kilograms");
        double weight;
        weight = input.nextDouble();
        System.out.println("Please Enter your height in meters");
        double height;
        height = input.nextDouble();
        System.out.println("Do you want to change your inputs: (Press Y to change or N to view)");
        String checkinput;
        checkinput = input.nextLine();
        while (checkinput.equals("Y") || checkinput.equals("y") || checkinput.equals("yes")) ;
        {
            System.out.println("Please Enter your name:");
            name = input.nextLine();
            System.out.println("Please enter your age as an Integer");
            age = input.nextInt();
            System.out.println("Please Enter your Gender");
            gender = input.nextLine();
            System.out.println("Please Enter your weight in Kilograms");
            weight = input.nextDouble();
            System.out.println("Please Enter your height in meters");
            height = input.nextDouble();
            System.out.println("Do you want to change your inputs: (Press Y to change or N to view)");
            checkinput = input.nextLine();
        }


        System.out.println("You are " + name);
        System.out.println("Weight:" + weight);
        System.out.println("Gender:" + gender);
        System.out.println("Age:" + age);
        double bmi = bmi(weight, height);
        System.out.println("Your BMI: " + bmi);
        System.out.println("You are " + bmicompare(bmi));
    }

    public static double bmi(double weight, double height) {
        double bmi = weight / (height * height);
        return bmi;

    }

    public static String bmicompare(double bmi) {
        if (bmi < 18.5)
            return "Thinness";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";

    }

    //Weight gain to get to bmi


}

