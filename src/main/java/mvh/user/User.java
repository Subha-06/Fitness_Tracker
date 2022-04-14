/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * Date: March 2nd, 2022- April 15, 2022.
 * Tutorial 05 and Tutorial 10.
 * Project Final Submission
 */
package mvh.user;

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

    //ToString method created
    public String toString() {
        return String.format("""
                Name: %s\s
                Gender: %s\s
                Age: %s\s
                Weight in Kgs: %s\s
                Height in centimeters: %s\s
                """, userName, userGender, (int)userAge, userWeight, userHeight);
    }

}
