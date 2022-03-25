/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 1 March 2022
 * * Demo 2 Tutorial 05
 */
package Util;

import Main.*;

import java.io.*;
import java.util.ArrayList;

public class Reader {

    static final int USER_NAME = 0;
    static final int USER_GEN = 1;
    static final int USER_AGE = 2;
    static final int USER_WEIGHT = 3;
    static final int USER_HEIGHT = 4;

    public static User reader(File fileInput) throws IOException {

        FileReader file_reader = new FileReader(fileInput);
        BufferedReader b_reader = new BufferedReader(file_reader);

        String userName;
        String userGender;
        double userAge;
        double userWeight;
        double userHeight;

        User Female = null;
        User Male = null;
        User user = null;

        String line = b_reader.readLine();
        while (line != null) {

            String[] userInfo = line.split(",");

            if (userInfo[USER_GEN].equals("F")) {

                userName = userInfo[USER_NAME];
                userGender = userInfo[USER_GEN];
                userAge = Double.parseDouble(userInfo[USER_AGE]);
                userWeight = Double.parseDouble(userInfo[USER_WEIGHT]);
                userHeight = Double.parseDouble(userInfo[USER_HEIGHT]);

                Female = new User(userName, userGender, userAge, userWeight, userHeight);

            } else if (userInfo[USER_GEN].equals("M")) {

                userName = userInfo[USER_NAME];
                userGender = userInfo[USER_GEN];
                userAge = Double.parseDouble(userInfo[USER_AGE]);
                userWeight = Double.parseDouble(userInfo[USER_WEIGHT]);
                userHeight = Double.parseDouble(userInfo[USER_HEIGHT]);

                Male = new User(userName, userGender, userAge, userWeight, userHeight);

            } else if (userInfo[USER_GEN].equals("N")){
                userName = userInfo[USER_NAME];
                userGender = userInfo[USER_GEN];
                userAge = Double.parseDouble(userInfo[USER_AGE]);
                userWeight = Double.parseDouble(userInfo[USER_WEIGHT]);
                userHeight = Double.parseDouble(userInfo[USER_HEIGHT]);

                user = new User(userName, userGender, userAge, userWeight, userHeight);

            }
            line = b_reader.readLine();
        }
        return user;
    }


    public static ArrayList<String> outReader() throws IOException {
        File outFile = new File("User.txt");
        ArrayList<String> outInfo = null;
        if (outFile.exists()) {

            FileReader f_reader = new FileReader(outFile);
            BufferedReader b_reader = new BufferedReader(f_reader);

            String line = b_reader.readLine();
            outInfo = new ArrayList<>();
            while (line != null) {

                outInfo.add(line);

                line = b_reader.readLine();
            }
        }
        return outInfo;
    }
}
