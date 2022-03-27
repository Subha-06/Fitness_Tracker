/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 1 March 2022
 * * Demo 2 Tutorial 05
 */
package Main;

public class Male extends User {

    public Male(String name, String gender, double age, double weight, double height) {
        super(name, gender, age, weight, height);

    }

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
