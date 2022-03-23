package Main;

import java.util.Scanner;

public class User {
    private static final Scanner scanner = new Scanner(System.in);

    private String userName;
    private String userGender;
    private double userAge;
    private double userWeight;
    private double userHeight;

    //Getter
    public String getUserName(){
        return userName;
    }

    public String getUserGender(){
        return userGender;
    }

    public double getUserAge(){
        System.out.println("Please Enter your age in centimeters:");

        userAge = scanner.nextDouble();
        //If the age is less than or equals to zero ask the user for input again.
        if (userAge < 0 || userAge == 0) {
            System.out.println("The input is not valid, height cannot be a negative number or zero");
            userAge = getUserAge();
        }
        return userAge;
    }

    public double getUserWeight(){
        System.out.println("Please Enter your height in centimeters:");

        userWeight = scanner.nextDouble();
        //If the weight is less than or equals to zero ask the user for input again.
        if (userWeight < 0 || userWeight == 0) {
            System.out.println("The input is not valid, height cannot be a negative number or zero");
            userWeight = getUserWeight();
        }
        return userWeight;
    }

    public double getUserHeight(){
        System.out.println("Please Enter your height in centimeters:");

        userHeight = scanner.nextDouble();
        //If the height is less than or equals to zero ask the user for input again.
        if (userHeight < 0 || userHeight == 0) {
            System.out.println("The input is not valid, height cannot be a negative number or zero");
            userHeight = getUserHeight();
        }
        return userHeight;
    }

    //Setter
    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setUserGender(String userGender){
        this.userGender = userGender;
    }

    public void setUserAge(int userAge){
        this.userAge = userAge;
    }

    public void setUserWeight(int userWeight){
        this.userWeight = userWeight;
    }

    public void setUserHeight(int userHeight){
        this.userHeight = userHeight;
    }
}
