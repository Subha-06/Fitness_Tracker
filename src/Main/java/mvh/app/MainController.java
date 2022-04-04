package mvh.app;


import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
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
    private void createUser() {

    }

    /**
     * Setup the window state
     */
    @FXML
    public void initialize() {
    }

}