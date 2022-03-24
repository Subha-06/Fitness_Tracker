/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 1 March 2022
 * * Demo 2 Tutorial 05
 */
package Main;

import java.util.Scanner;

public class User {
    //Creating a scanner
    private static final Scanner scanner = new Scanner(System.in);

    private String userName;
    private String userGender;
    private double userAge;
    private double userWeight;
    private double userHeight;

    //Getter
    public String getUserName() {
        return userName;
    }

    public String getUserGender() {
        return userGender;
    }

    /**
     * This function makes sure the user inputs a valid number because age has to be over 0.
     *
     * @return returns the age of the user
     */

    public double getUserAge() {
        return userAge;
    }

    /**
     * This function makes sure the user inputs a valid number because weight has to be over 0.
     *
     * @return returns the weight of the user
     */

    public double getUserWeight() {
        return userWeight;
    }

    /**
     * This function makes sure the user inputs a valid number because height has to be over 0.
     *
     * @return returns the height of the user
     */


    public double getUserHeight() {
        return userHeight;
    }

    //Setter
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public void setUserAge(double userAge) {
        this.userAge = userAge;
    }

    public void setUserWeight(double userWeight) {
        this.userWeight = userWeight;
    }

    public void setUserHeight(double userHeight) {
        this.userHeight = userHeight;
    }
}
