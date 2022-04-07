/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 1 March 2022
 * * Demo 2 Tutorial 05
 */
package mvh.util;

import mvh.app.Main;
import mvh.app.MainController;
import mvh.user.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

                while (line != null) {
                    //The file is csv so separating them and storing them in a string
                    String[] userInfo = line.split(",");

                    //Checking the gender of the user to assign the information accordingly
                    //Assigning the information of the file to variables
                    userNumber = Integer.parseInt(userInfo[USER_NUMBER]);
                    userName = userInfo[USER_NAME];
                    userGender = userInfo[USER_GEN];
                    userAge = Double.parseDouble(userInfo[USER_AGE]);
                    userWeight = Double.parseDouble(userInfo[USER_WEIGHT]);
                    userHeight = Double.parseDouble(userInfo[USER_HEIGHT]);

                    user = new User(userName, userGender, userAge, userWeight, userHeight);
                    MainController.userInfo.put(userNumber, user);

                    line = b_reader.readLine();
                }
            } catch (Exception e) {
                System.err.println("File is empty!");
            }
        }
    }

    /**
     * Creates an array list with calories burnt info
     *
     * @return An array list containing the user input data about calories burnt
     */
    public static ArrayList<String> outReader() throws IOException {
        //The file that stores the information of calories burnt.
        File outFile = new File("User.txt");
        //Initializing an empty arraylist.
        ArrayList<String> outInfo = null;
        if (outFile.exists()) {
            //Creating a file reader and a buffered reader
            FileReader f_reader = new FileReader(outFile);
            BufferedReader b_reader = new BufferedReader(f_reader);
            //Reading lines until the file is empty.
            String line = b_reader.readLine();
            outInfo = new ArrayList<>();
            while (line != null) {
                //Adding the information to the arraylist.
                outInfo.add(line);
                line = b_reader.readLine();
            }
        }
        //If file does not exist
        else {
            System.err.println("Cannot find a file to read!");
        }
        //Returns the arraylist with calorie information.
        return outInfo;
    }
}
