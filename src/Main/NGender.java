/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 1 March 2022
 * * Demo 2 Tutorial 05
 */
package Main;

/**
 * A user entity created by user provided information
 */

public class NGender extends User {
    /**
     * A person has a name, gender, age, height , weight
     *
     * @param name   The name of the user
     * @param gender The gender of the user
     * @param age    The age of the user
     * @param weight The weight of the user
     * @param height The height of the user
     */

    public NGender(String name, String gender, double age, double weight, double height) {
        //super is used to get constructor from User.class
        super(name, gender, age, weight, height);

    }

    /**
     * Properly formats the user information.
     *
     * @return returns a string of the desired output
     */


    public String toString() {
        return String.format("""
                User Name: %s\s
                Gender: %s\s
                Age: %s\s
                Weight in Kgs: %s\s
                Height in centimeters: %s\s
                """, userName, userGender, userAge, userWeight, userHeight);
    }
}
