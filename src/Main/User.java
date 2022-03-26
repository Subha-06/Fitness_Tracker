/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 1 March 2022
 * * Demo 2 Tutorial 05
 */
package Main;

public class User {


    public String userName;
    public String userGender;
    public double userAge;
    public double userWeight;
    public double userHeight;

    public User(String name, String gender, double age, double weight, double height) {
        userName = name;
        userGender = gender;
        userAge = age;
        userWeight = weight;
        userHeight = height;
    }

    //Getter
    public String getUserName() {
        return userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public double getUserAge() {
        return userAge;
    }

    public double getUserWeight() {
        return userWeight;
    }


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
