/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 8th April 2022
 * * Demo 3 Tutorial 05
 */
package mvh.util;

import mvh.app.MainController;
import mvh.user.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Writer {

    /**
     * Writes the information in a file
     *
     * @param outInfo The information that the user wants to save in a file
     */
    public static void writer(HashMap<Integer,String> outInfo) throws IOException {

        File newFile = new File("User.txt");
        //If file does not exist create new file
        newFile.createNewFile();

        //Checking if the file exits and can write on it
        if (newFile.exists() && newFile.canWrite()) {
            try {
                //Append so that information is added to the next line
                FileWriter f_writer = new FileWriter(newFile, true);
                BufferedWriter b_writer = new BufferedWriter(f_writer);

                //Writing the information to the file
                for (Integer i : outInfo.keySet()){
                    b_writer.write(i + "," + outInfo.get(i));
                    b_writer.newLine();
                }

                b_writer.flush();
                b_writer.close();
            //Exception handled
            } catch (IOException e) {
                System.err.println("Cannot access the file to write it!");
            }
        } else {
            System.err.println("Cannot access the file to write it!");
        }
    }

    /**
     *
     * @param keyCheck Boolean variable to check if the user already exists in the data storage
     * @param userNumber The key to the information of the user in the hashmap
     * @param userName The name of the user that is manually entered if the user doesn't exist
     * @param userAge The age of the user that is manually entered if the user doesn't exist
     * @param userGender The gender of the user that is manually entered if the user doesn't exist
     * @param userWeight The weight of the user that is manually entered if the user doesn't exist
     * @param userHeight The height of the user that is manually entered if the user doesn't exist
     * @throws IOException
     */
    public static void fileWriter(Boolean keyCheck, int userNumber, String userName, String userAge, String userGender, String userWeight, String userHeight) throws IOException {

        File newFile = new File("UserInfo.txt");
        newFile.createNewFile();

        //Checking if the file exist and can write on it
        if (newFile.exists() && newFile.canWrite()) {
            try {
                //Setting up the writer
                FileWriter f_writer = new FileWriter(newFile, true);
                BufferedWriter b_writer = new BufferedWriter(f_writer);

                //Checking if the user already exists
                if (keyCheck) {
                    //Getting the user info from the hashmap
                    User user = (User) MainController.userInfo.get(userNumber);

                    //Assigning the info to the variables
                    String name = user.getUserName();
                    String age = String.valueOf(user.getUserAge());
                    String gender = String.valueOf(user.getUserGender().charAt(0));
                    String weight = String.valueOf(user.getUserWeight());
                    String height = String.valueOf(user.getUserHeight());

                    //Writing the information in the file
                    b_writer.write(userNumber + "," + name + "," + age + "," + gender + "," + weight + "," + height);
                    b_writer.newLine();
                    b_writer.flush();

                //If the user doesn't exist
                } else if (!keyCheck){

                    //User manually enters the info which is passed in the parameters of the method from the text fields
                    //Writing the information in the file
                    b_writer.write(userNumber + "," + userName + "," + userAge + "," + userGender + "," + userWeight + "," + userHeight);
                    b_writer.newLine();
                    b_writer.flush();
                }
            //Exception handled
            } catch (IOException e) {
                System.err.println("File not found");
            }
        }
    }
}
