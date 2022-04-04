///**
// * A fitness tracking program that allows the user to input their information and get back various results form that
// * *Members:
// * Fabiha Fairuzz Subha (UCID: 30148674)
// * Amasil Rahim Zihad (UCID: 30164830)
// * * Date: 1 March 2022
// * * Demo 2 Tutorial 05
// */
//package mvh.Util;
//
//import mvh.app.Main;
//import mvh.user.*;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class Reader {
//    //We know that the information will always be in this order.
//    static final int USER_NAME = 0;
//    static final int USER_GEN = 1;
//    static final int USER_AGE = 2;
//    static final int USER_WEIGHT = 3;
//    static final int USER_HEIGHT = 4;
//
//    /**
//     * Reads information from a file
//     *
//     * @param fileInput The input file containing the user information to be read
//     */
//    public static void reader(File fileInput) throws IOException {
//        //Creating a file reader and a buffered reader
//        FileReader file_reader = new FileReader(fileInput);
//        BufferedReader b_reader = new BufferedReader(file_reader);
//
//        //Setting the variables
//        String userName;
//        String userGender;
//        double userAge;
//        double userWeight;
//        double userHeight;
//        User user;
//
//        //Looping through the file to read all lines of information from the file
//        String line = b_reader.readLine();
//        while (line != null) {
//            //The file is csv so separating them and storing them in a string
//            String[] userInfo = line.split(",");
//
//            //Checking the gender of the user to assign the information accordingly
//            switch (userInfo[USER_GEN]) {
//                case "Female", "F", "f" -> {
//                    //Assigning the information of the file to variables
//                    userName = userInfo[USER_NAME];
//                    userGender = "Female";
//                    userAge = Double.parseDouble(userInfo[USER_AGE]);
//                    userWeight = Double.parseDouble(userInfo[USER_WEIGHT]);
//                    userHeight = Double.parseDouble(userInfo[USER_HEIGHT]);
//
//                    //Creating new user object to store individual user information
//                    user = new Female(userName, userGender, userAge, userWeight, userHeight);
//                    Main.femaleList.add(user);
//                }
//
//                //Checking the gender of the user to assign the information accordingly
//                case "Male", "M", "m" -> {
//
//                    //Assigning the information of the file to variables
//                    userName = userInfo[USER_NAME];
//                    userGender = "Male";
//                    userAge = Double.parseDouble(userInfo[USER_AGE]);
//                    userWeight = Double.parseDouble(userInfo[USER_WEIGHT]);
//                    userHeight = Double.parseDouble(userInfo[USER_HEIGHT]);
//
//                    //Creating new user object to store individual user information
//                    user = new Male(userName, userGender, userAge, userWeight, userHeight);
//                    Main.maleList.add(user);
//                }
//
//                //Checking the gender of the user to assign the information accordingly
//                case "Preferred not to say", "N", "n" -> {
//
//                    //Assigning the information of the file to variables
//                    userName = userInfo[USER_NAME];
//                    userGender = "You choose not to say";
//                    userAge = Double.parseDouble(userInfo[USER_AGE]);
//                    userWeight = Double.parseDouble(userInfo[USER_WEIGHT]);
//                    userHeight = Double.parseDouble(userInfo[USER_HEIGHT]);
//
//                    //Creating new user object to store individual user information
//                    user = new NGender(userName, userGender, userAge, userWeight, userHeight);
//                    Main.nUserList.add(user);
//                }
//            }
//            //Read the next line
//            line = b_reader.readLine();
//        }
//    }
//
//    /**
//     * Creates an array list with calories burnt info
//     *
//     * @return An array list containing the user input data about calories burnt
//     */
//    public static ArrayList<String> outReader() throws IOException {
//        //The file that stores the information of calories burnt.
//        File outFile = new File("User.txt");
//        //Initializing an empty arraylist.
//        ArrayList<String> outInfo = null;
//        if (outFile.exists()) {
//            //Creating a file reader and a buffered reader
//            FileReader f_reader = new FileReader(outFile);
//            BufferedReader b_reader = new BufferedReader(f_reader);
//            //Reading lines until the file is empty.
//            String line = b_reader.readLine();
//            outInfo = new ArrayList<>();
//            while (line != null) {
//                //Adding the information to the arraylist.
//                outInfo.add(line);
//                line = b_reader.readLine();
//            }
//        }
//        //If file does not exist
//        else {
//            System.err.println("Cannot find a file to read!");
//        }
//        //Returns the arraylist with calorie information.
//        return outInfo;
//    }
//}
