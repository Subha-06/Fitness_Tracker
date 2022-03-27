/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 1 March 2022
 * * Demo 2 Tutorial 05
 */
package Main;

import Util.Reader;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static Util.Menu.*;

public class Main {

    //Setting the static ArrayLists and HashMaps for storing the user info
    public static ArrayList<User> nUserList = new ArrayList<>();
    public static ArrayList<User> femaleList = new ArrayList<>();
    public static ArrayList<User> maleList = new ArrayList<>();
    public static HashMap<String, String> userInfo1 = new HashMap<>();
    public static HashMap<String, Double> userInfo2 = new HashMap<>();

    /**
     * Start the tracking program
     *
     * @param args No arguments expected
     */
    public static void main(String[] args) throws IOException {
        //Getting file names
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, This is a fitness tracking program");
        System.out.println("""
                If you want to enter your information press '1'
                If you want to enter your information from a file press '2'
                To exit the program press anything else
                """);
        String userchoice = scanner.nextLine();
        if (userchoice.equals("1")) {
            int flag = 0;
            getUserChoice(getUserInput(flag));
        }
        if (userchoice.equals("2")) {
            if (args.length != 0) {
                File fileInput = new File(args[0]);
                if (fileInput.exists() && fileInput.canRead()) {
                    getUserChoice(Reader.reader(fileInput));
                }
            } else {
                System.err.println("File Not Found!");
            }
        } else {
            System.err.println("You choose to exit the program.");
        }
    }

    /**
     * @param userInfo1 The HashMap containing string type information of the user entered manually (Contains name and gender)
     * @param userInfo2 The HashMap containing double type information of the user entered manually (Contains age, height and weight)
     */
    public static void printInfo(HashMap<String, String> userInfo1, HashMap<String, Double> userInfo2) {
        String gender = "";
        //Changing the gender of the user from a short version to abbreviated version.
        if (userInfo1.isEmpty() && userInfo2.isEmpty()) {
            System.err.println("No information found!");
        } else {
            //The second element of this hashmap will always be the keyword of the gender.
            String genderWord = (String) userInfo1.values().toArray()[1];
            switch (genderWord) {
                case "M" -> gender = "Male";
                case "N" -> gender = "You choose not to say";
                case "F" -> gender = "Female";
            }
            //The 0 element is the name and "Name:"
            //The 1 element is the gender of the user
            String name = (String) userInfo1.values().toArray()[0];
            //Printing the name
            System.out.println(userInfo1.keySet().toArray()[0] + name);
            //Printing the gender
            System.out.println(userInfo1.keySet().toArray()[1] + gender);
            //Printing the age, height. weight
            for (String j : userInfo2.keySet()) {
                System.out.println(j + userInfo2.get(j));
            }
        }
    }
}


