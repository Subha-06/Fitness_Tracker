/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * Date: March 2nd, 2022- April 15, 2022
 * Tutorial 05 and Tutorial 10.
 * Project Final Submission
 */
package mvh.util;

import mvh.app.MainController;
import mvh.user.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Reader {
    //We know that the information will always be in this order.
    static final int USER_NUMBER = 0;
    static final int USER_NAME = 1;
    static final int USER_GEN = 3;
    static final int USER_AGE = 2;
    static final int USER_WEIGHT = 4;
    static final int USER_HEIGHT = 5;

    /**
     * Reads information from a file
     *
     * @param fileInput The input file containing the user information to be read
     */
    public static void reader(File fileInput) throws IOException {
        //Creating a file reader and a buffered reader
        FileReader file_reader = new FileReader(fileInput);
        BufferedReader b_reader = new BufferedReader(file_reader);

        //Setting the variables
        int userNumber;
        String userName;
        String userGender;
        double userAge;
        double userWeight;
        double userHeight;
        User user;

        if (fileInput.exists() && fileInput.canRead()) {
            try {
                //Looping through the file to read all lines of information from the file
                String line = b_reader.readLine();
                if (line == null) {
                    System.err.println("File is empty!");
                } else {
                    while (line != null) {
                        //The file is csv so separating them and storing them in a string
                        String[] userInfo = line.split(",");
                        //Checking the gender of the user to assign the information accordingly
                        //Assigning the information of the file to variables
                        try {
                            userNumber = Integer.parseInt(userInfo[USER_NUMBER]);
                            try {
                                //Since the program works for 10 user the userNumber will need to be between 1 and 10
                                if (userNumber < 1 || userNumber > 10) {
                                    System.err.println("The User Number is less than 1 or greater than 10");
                                } else {
                                    userName = userInfo[USER_NAME];
                                    try {
                                        userGender = userInfo[USER_GEN];
                                        //User Gender can only be M or N or F
                                        if (!userGender.equals("M") && !userGender.equals("N") && !userGender.equals("F")) {
                                            System.err.println("There is a problem with assigning " + userName + "’s gender.");
                                        } else {
                                            //Abbreviating the M, N and F.
                                            if (userInfo[USER_GEN].equals("M")) {
                                                userGender = "Male";
                                            }
                                            if (userInfo[USER_GEN].equals("F")) {
                                                userGender = "Female";
                                            }
                                            if (userInfo[USER_GEN].equals("N")) {
                                                userGender = "Preferred not to say";
                                            }
                                            try {
                                                userAge = Double.parseDouble(userInfo[USER_AGE]);
                                                //Age has to be a positive number
                                                if (userAge <= 0) {
                                                    System.err.println(userName + "’s age is 0 or a negative number");
                                                } else {
                                                    try {
                                                        //Weight has to be a positive number
                                                        userWeight = Double.parseDouble(userInfo[USER_WEIGHT]);
                                                        if (userWeight <= 0) {
                                                            System.err.println(userName + "’s weight is 0 or a negative number");
                                                        } else {
                                                            try {
                                                                //Height has to be a positive number
                                                                userHeight = Double.parseDouble(userInfo[USER_HEIGHT]);
                                                                if (userHeight <= 0) {
                                                                    System.err.println(userName + "’s height is 0 or a negative number");
                                                                } else {
                                                                    //Creating a user using all the user information
                                                                    user = new User(userName, userGender, userAge, userWeight, userHeight);
                                                                    MainController.userInfo.put(userNumber, user);
                                                                }
                                                            }
                                                            //Exception handled
                                                            catch (Exception e) {
                                                                System.err.println("There was a problem parsing the Height of " + userName);
                                                            }
                                                        }
                                                    }
                                                    //Exception handled
                                                    catch (Exception e) {
                                                        System.err.println("There was a problem parsing the weight of " + userName);
                                                    }
                                                }
                                            }
                                            //Exception handled
                                            catch (Exception e) {
                                                System.err.println("There was a problem parsing the age of " + userName);
                                            }
                                        }
                                    }
                                    //Exception handled
                                    catch (Exception e) {
                                        System.err.println("There was a problem assigning the gender of " + userName);
                                    }
                                }
                            }
                            //Exception handled
                            catch (Exception e) {
                                System.err.println("There is an Issue with the user number");
                            }
                        }
                        //Exception handled
                        catch (Exception e) {
                            System.err.println("There is a problem with the user number.");
                        }
                        //Read the next line
                        line = b_reader.readLine();
                    }
                }
                //Exception handled
            } catch (Exception e) {
                System.err.println("There is an Issue with the file");
            }
        }
    }

    /**
     * Creates an array list with calories burnt info
     *
     * @return An array list containing the user input data about calories burnt
     */
    public static HashMap<Integer, ArrayList<Integer>> outReader(int userNumber, File outFile) throws IOException {
        //The file that stores the information of calories burnt.
        //Initializing an empty Hashmap and a new Arraylist for storing the data.
        HashMap<Integer, ArrayList<Integer>> outInfo = null;
        ArrayList<Integer> list = new ArrayList<>();
        if (outFile.exists()) {
            //Creating a file reader and a buffered reader
            FileReader f_reader = new FileReader(outFile);
            BufferedReader b_reader = new BufferedReader(f_reader);
            //Reading lines until the file is empty.
            String line = b_reader.readLine();
            outInfo = new HashMap<>();
            while (line != null) {
                String[] readInfo = line.split(",");

                if (readInfo[0].equals(String.valueOf(userNumber))) {
                    //Adding the calorie information to the arraylist.
                    list.add(Integer.parseInt(readInfo[1]));
                }
                line = b_reader.readLine();
                //Adding the calorie information to the hashmap
                outInfo.put(userNumber, list);
            }
        }
        //If file does not exist
        else {
            System.err.println("Cannot find a file to read!");
        }
        //Returns the HashMap with calorie information.
        return outInfo;

    }
}
