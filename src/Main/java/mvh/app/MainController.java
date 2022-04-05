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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {


    @FXML
    private TextField userName;
    @FXML
    private TextField userAge;
    @FXML
    private TextField userWeight;
    @FXML
    private TextField userHeight;
    @FXML
    private ChoiceBox<String> userGender;
    @FXML
    private ChoiceBox<String> choiceOfExercise;
    @FXML
    private ChoiceBox<String> choiceOfCycleSpeed;
    @FXML
    private ChoiceBox<String> choiceOfWalkSpeed;
    @FXML
    private Label leftStatus;
    @FXML
    private Label rightStatus;
    @FXML
    private TextField newWorldColumn;
    @FXML
    private TextField heroColumn;
    @FXML
    private TextField heroRow;
    @FXML
    private TextField monsterSymbol;

    @FXML
    private void createUser() {

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
    public void initialize() {

    }


}