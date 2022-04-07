/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 1 March 2022
 * * Demo 2 Tutorial 05
 */
package mvh.util;

import mvh.app.MainController;
import mvh.user.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    /**
     * Writes the information in a file
     *
     * @param out_info The information that the user wants to save in a file
     */
    public static void writer(int userNumber, int out_info) throws IOException {

        File newFile = new File("User.txt");
        //If file does not exist create new file
        newFile.createNewFile();

        //Checking if the file exits and can write on it
        if (newFile.exists() && newFile.canWrite()) {
            try {
                //Append so that information is added to the next line
                FileWriter f_writer = new FileWriter(newFile, true);
                BufferedWriter b_writer = new BufferedWriter(f_writer);

                b_writer.write(userNumber + "," + out_info + "\n");

                b_writer.flush();
            } catch (IOException e) {
                System.err.println("Cannot access the file to write it!");
            }
        } else {
            System.err.println("Cannot access the file to write it!");
        }
    }

    public static void fileWriter(Boolean keyCheck, int userNumber, String userName, String userAge, String userGender, String userWeight, String userHeight) throws IOException {

        File newFile = new File("UserInfo.txt");
        newFile.createNewFile();

        //Checking if the file exist and can write on it
        if (newFile.exists() && newFile.canWrite()) {
            try {
                FileWriter f_writer = new FileWriter(newFile, true);
                BufferedWriter b_writer = new BufferedWriter(f_writer);

                if (keyCheck) {
                    User user = (User) MainController.userInfo.get(userNumber);

                    String name = user.getUserName();
                    String age = String.valueOf(user.getUserAge());
                    String gender = String.valueOf(user.getUserGender().charAt(0));
                    String weight = String.valueOf(user.getUserWeight());
                    String height = String.valueOf(user.getUserHeight());


                    b_writer.write(userNumber + "," + name + "," + age + "," + gender + "," + weight + "," + height);
                    b_writer.newLine();
                    b_writer.flush();

                } else if (!keyCheck){

                    b_writer.write(userNumber + "," + userName + "," + userAge + "," + userGender + "," + userWeight + "," + userHeight);
                    b_writer.newLine();
                    b_writer.flush();
                }
            } catch (IOException e) {
                System.err.println("File not found");
            }
        }
    }

}
