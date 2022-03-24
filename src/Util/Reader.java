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

public class Reader {

    static final int USER_NAME = 0;
    static final int USER_GEN = 1;
    static final int USER_AGE = 2;
    static final int USER_WEIGHT = 3;
    static final int USER_HEIGHT = 4;

    public static User reader(File fileInput) throws IOException {

        FileReader file_reader = new FileReader(fileInput);
        BufferedReader b_reader = new BufferedReader(file_reader);
        User user = new User();

        String line = b_reader.readLine();
        while (line != null) {
            String[] userInfo = line.split(",");
            if (userInfo[USER_GEN].equals("F")) {
                System.out.println("Here");
                String userName = userInfo[USER_NAME];
                String userGender = userInfo[USER_GEN];
                double userAge = Double.parseDouble(userInfo[USER_AGE]);
                double userWeight = Double.parseDouble(userInfo[USER_WEIGHT]);
                double userHeight = Double.parseDouble(userInfo[USER_HEIGHT]);

                user.setUserName(userName);
                user.setUserGender(userGender);
                user.setUserAge(userAge);
                user.setUserWeight(userWeight);
                user.setUserHeight(userHeight);

            }
            if (userInfo[USER_GEN].equals("M")) {
                System.out.println("Here too");
                String userName = userInfo[USER_NAME];
                String userGender = userInfo[USER_GEN];
                double userAge = Double.parseDouble(userInfo[USER_AGE]);
                double userWeight = Double.parseDouble(userInfo[USER_WEIGHT]);
                double userHeight = Double.parseDouble(userInfo[USER_HEIGHT]);

                user.setUserName(userName);
                user.setUserGender(userGender);
                user.setUserAge(userAge);
                user.setUserWeight(userWeight);
                user.setUserHeight(userHeight);

            }
            if (userInfo[USER_GEN].equals("N")) {
                System.out.println("Why?");
                String userName = userInfo[USER_NAME];
                String userGender = userInfo[USER_GEN];
                double userAge = Double.parseDouble(userInfo[USER_AGE]);
                double userWeight = Double.parseDouble(userInfo[USER_WEIGHT]);
                double userHeight = Double.parseDouble(userInfo[USER_HEIGHT]);

                user.setUserName(userName);
                user.setUserGender(userGender);
                user.setUserAge(userAge);
                user.setUserWeight(userWeight);
                user.setUserHeight(userHeight);
            }
            line = b_reader.readLine();
        }
        return user;
    }
}
