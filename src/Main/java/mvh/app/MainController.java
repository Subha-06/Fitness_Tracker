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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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

    @FXML
    private void createUser() {

        try {
            int num = (userNumber.getValue());
            String name = userName.getText();
            int age = Integer.parseInt(userAge.getText());
            String gender = String.valueOf(userGender.getValue().charAt(0));
            double weight = Double.parseDouble(userWeight.getText());
            double height = Double.parseDouble(userHeight.getText());

            user = new User(name, gender, age, weight, height);

            userInfo.put(num, user);

            leftStatus.setText("User Added!");
            rightStatus.setText("Choose from menu");
            System.out.println(userInfo.get(num).toString());

        } catch (NumberFormatException e) {
            leftStatus.setText("Invalid Input!");
            rightStatus.setText("Enter again");
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
                Version: At this point no one knows
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
            int num = (viewUserNumber.getValue());

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


}