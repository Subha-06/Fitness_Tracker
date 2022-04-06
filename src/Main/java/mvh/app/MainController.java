/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 1 March 2022
 * * Demo 2 Tutorial 05
 */
package mvh.app;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import mvh.user.User;

import java.util.HashMap;

public class MainController {

    private User user;
    public static HashMap<Integer, Object> userInfo = new HashMap<>();
    @FXML
    private ChoiceBox<Integer> userNumber;
    @FXML
    private ChoiceBox<Integer> viewUserNumber;
    @FXML
    private ChoiceBox<String> viewInfoType;
    @FXML
    private ChoiceBox<String> exerciseChoice;
    @FXML
    private ChoiceBox<String> choiceOfSpeed;
    @FXML
    private ChoiceBox<Integer> calorieUser;
    @FXML
    private ChoiceBox<String> weightChoice;
    @FXML
    private ChoiceBox<String> heightChoice;
    @FXML
    private ChoiceBox<String> calorieViewType;
    @FXML
    private TextField userName;
    @FXML
    private TextField userAge;
    @FXML
    private TextField userWeight;
    @FXML
    private TextField userHeight;
    @FXML
    private TextField calorieAmount;
    @FXML
    private ChoiceBox<String> userGender;
    @FXML
    private Label leftStatus;
    @FXML
    private Label rightStatus;
    @FXML
    private TextArea viewDetails;

    @FXML
    public void initialize() {

        weightChoice.getItems().clear();
        weightChoice.setValue("KG");
        weightChoice.getItems().addAll("KG", "LB");

        heightChoice.getItems().clear();
        heightChoice.setValue("C.M.");
        heightChoice.getItems().addAll("C.M.", "Meter");

        calorieViewType.getItems().clear();
        calorieViewType.setValue("Total Calorie Lost");
        calorieViewType.getItems().addAll("Total Calorie Lost", "Most amount burnt");

        exerciseChoice.getItems().clear();
        exerciseChoice.setValue("Walking");
        exerciseChoice.getItems().addAll("Walking", "Cycling");

        calorieUser.getItems().clear();
        calorieUser.setValue(1);
        calorieUser.getItems().addAll(1, 2, 3, 4, 5);

        userNumber.getItems().clear();
        userNumber.setValue(1);
        userNumber.getItems().addAll(1, 2, 3, 4, 5);

        userGender.getItems().clear();
        userGender.setValue("Male");
        userGender.getItems().addAll("Male", "Female", "Preferred not to say");

        viewUserNumber.getItems().clear();
        viewUserNumber.setValue(1);
        viewUserNumber.getItems().addAll(1, 2, 3, 4, 5);

        viewInfoType.getItems().clear();
        viewInfoType.setValue("View BMI");
        viewInfoType.getItems().addAll("View BMI", "View Weight Status");
        choiceOfSpeed.setValue("6-7 km/h");
    }

    @FXML
    void addCalorieBurnt() {

    }

    @FXML
    void viewCalorieInfo() {

    }

    /**
     * Adding an User
     */

    @FXML
    private void createUser() {
        try {
            //IF any of the field is empty the program will show an Error.
            if (userName.getText().equals("") || userAge.getText().equals("") || userWeight.getText().equals("") || userHeight.getText().equals("")) {
                leftStatus.setText("Please Enter All Information");
                leftStatus.setTextFill(Color.RED);
                rightStatus.setText("");
            } else {
                int num = (userNumber.getValue());
                String name = userName.getText();
                String gender = String.valueOf(userGender.getValue());
                //Trying To get valid input from the user
                try {
                    int age = Integer.parseInt(userAge.getText());
                    //Age Can't be Negative or 0
                    if (age <= 0) {
                        leftStatus.setText("Please Enter A Positive Number For age");
                        leftStatus.setTextFill(Color.RED);
                        rightStatus.setText("");
                    } else {
                        //Weight Can't be Negative or 0
                        try {
                            //If the option chosen is kilograms
                            double weight;
                            if (weightChoice.getValue().equals("KG")) {
                                weight = Double.parseDouble(userWeight.getText());
                            }
                            //If the option chosen is anything else
                            else {
                                //Converting the lbs to kg
                                weight = 2.2 * Double.parseDouble(userWeight.getText());
                            }
                            if (weight <= 0) {
                                leftStatus.setText("Please Enter A Positive Number For Weight");
                                leftStatus.setTextFill(Color.RED);
                                rightStatus.setText("");
                            } else {
                                try {
                                    //If height is cm
                                    double height;
                                    if (heightChoice.getValue().equals("C.M.")) {
                                        height = Double.parseDouble(userHeight.getText());
                                    } else {
                                        //Converting meter to cm
                                        height = 100 * Double.parseDouble(userHeight.getText());
                                    }
                                    if (height <= 0) {
                                        leftStatus.setText("Please Enter A Positive Number For Height");
                                        leftStatus.setTextFill(Color.RED);
                                        rightStatus.setText("");
                                    } else {
                                        try {
                                            //Creating the user
                                            user = new User(name, gender, age, weight, height);
                                            userInfo.put(num, user);

                                            leftStatus.setText("");
                                            rightStatus.setText("User Added! Choose from menu");
                                            rightStatus.setTextFill(Color.GREEN);
                                            viewDetails.setText("");
                                        } catch (Exception e) {
                                            leftStatus.setText("Couldn't add user");
                                            leftStatus.setTextFill(Color.RED);
                                        }
                                    }
                                } catch (Exception e) {
                                    leftStatus.setText("Enter A Integer or Double for height");
                                    leftStatus.setTextFill(Color.RED);
                                    rightStatus.setText("");
                                }
                            }
                        } catch (Exception e) {
                            leftStatus.setText("Enter A Integer or Double for weight");
                            leftStatus.setTextFill(Color.RED);
                            rightStatus.setText("");
                        }
                    }
                } catch (Exception e) {
                    leftStatus.setText("Enter A Integer or Double for age");
                    leftStatus.setTextFill(Color.RED);
                    rightStatus.setText("");
                }
            }
        } catch (Exception e) {
            leftStatus.setText("Please Enter All Information");
            leftStatus.setTextFill(Color.RED);
            rightStatus.setText("");
        }
    }

    @FXML
    void exerciseSpeed() {
        if (exerciseChoice.getValue().equals("Walking")) {
            choiceOfSpeed.getItems().clear();
            choiceOfSpeed.setValue("6-7 km/h");
            choiceOfSpeed.getItems().addAll("6-7 km/h", "7-8 km/h", "9-11 km/h");
        } else {
            choiceOfSpeed.getItems().clear();
            choiceOfSpeed.setValue("16-19 km/h");
            choiceOfSpeed.getItems().addAll("16-19 km/h", "19-22 km/h", "22-25 km/h");
        }
    }

    /**
     * Shows the information of the creator of the program.
     */
    @FXML
    void viewAbout() {
        //Creating the alert box
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("About Author");
        alert.setContentText("""
                Author: Amasil Rahim Zihad & Fabiha Fairuzz Subha
                Version: 3.7
                This is fitness tracking program.""");
        //Showing the alert
        alert.showAndWait();

    }

    /**
     * Allows the user to quit the program.
     */

    @FXML
    void closeButton() {
        Platform.exit();
    }

    @FXML
    void viewInfo() {
        try {
            int num = viewUserNumber.getValue();

            viewDetails.setText(userInfo.get(num).toString());
            leftStatus.setText("User Info Printed!");
            rightStatus.setText("View above");

        } catch (Exception e) {

            leftStatus.setText("No user found");
            rightStatus.setText("Nothing printed");

        }
    }

    @FXML
    void viewExercise() {

    }

    @FXML
    void viewBMI() {
        int num = viewUserNumber.getValue();
        boolean keyCheck = userInfo.containsKey(num);
        try {
            if (viewInfoType.getValue().equals("View BMI")) {

                if (keyCheck) {

                    user = (User) userInfo.get(num);
                    double weight = user.getUserWeight();
                    double height = user.getUserHeight();

                    viewDetails.setText("Your BMI is " + mvh.util.Calculations.bmi(weight, height));

                    leftStatus.setText("Requested info shown!");
                    rightStatus.setText("Check the view box");

                } else {
                    leftStatus.setText("No user found!");
                    rightStatus.setText("Enter valid user number");
                }

            } else {

                if (keyCheck) {


                    user = (User) userInfo.get(num);
                    double weight = user.getUserWeight();
                    double height = user.getUserHeight();

                    viewDetails.setText(mvh.util.Calculations.bmiCompare(weight, height));

                    leftStatus.setText("Requested info shown!");
                    rightStatus.setText("Check the view box");
                } else {
                    leftStatus.setText("No user found!");
                    rightStatus.setText("Enter valid user number");
                }
            }
        } catch (NullPointerException e) {
            leftStatus.setText("No user found!");
            rightStatus.setText("Input user info");
        }
    }
}