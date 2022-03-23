package Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static Main.Main.getUserChoice;
import static Main.Main.reader;

public final class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void checkYes(){
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
            reader();

        } else {
            System.out.println("You choose to exit the program.");
            System.exit(0);
        }

    }

    public static void getUserInput() {

        System.out.println("Please Enter your name:");
        String name;
        name = scanner.nextLine();
        System.out.println("Please Enter your Gender (F for Female, M for Male or N if preferred not to say):");
        String gender;
        gender = scanner.nextLine();
        System.out.println("Please enter your age:");
        double age;
        age = scanner.nextInt();
        System.out.println("Please Enter your weight in Kilograms:");
        double weight;
        weight = scanner.nextDouble();
        System.out.println("Please Enter your height in centimeters:");
        double height;
        height = scanner.nextDouble();

        //Storing the data


        //Add the user information to an arraylist then add that arraylist to hashmap with the name as the key

        ArrayList<Double> userinfo = new ArrayList<>();
        userinfo.add(age);
        userinfo.add(weight);
        userinfo.add(height);


        HashMap<String, ArrayList> userinfo2 = new HashMap<>();
        userinfo2.put(name, userinfo);

        //Calls the menu after getting input from user.
        getUserChoice(name, gender, userinfo2);
    }




}
