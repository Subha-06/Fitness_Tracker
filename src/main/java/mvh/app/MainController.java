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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mvh.user.User;
import mvh.util.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

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
    private ChoiceBox<String> exerciseKGLB;
    @FXML
    private Label leftStatus;
    @FXML
    private Label rightStatus;
    @FXML
    private TextArea viewDetails;
    @FXML
    private TextField weightExercise;
    @FXML
    private int userNumberInt;
    @FXML
    private boolean keyCheck;
    @FXML
    private double weight;
    @FXML
    private double height;

    /**
     * Starts the program and puts the choices in the choiceBox.
     */
    @FXML
    public void initialize() {
        //Setting Up the choice boxes with the required options
        //Clear will make sure the options aren't repeated
        //Set to get a default value

        //User Input User Number
        userNumber.getItems().clear();
        userNumber.setValue(1);
        for (int i = 1; i <= 50; i++) {
            userNumber.getItems().add(i);
        }

        //User Gender
        userGender.getItems().clear();
        userGender.setValue("Male");
        userGender.getItems().addAll("Male", "Female", "Preferred not to say");

        //User weight input kg or lb
        exerciseKGLB.getItems().clear();
        exerciseKGLB.setValue("KG");
        exerciseKGLB.getItems().addAll("KG", "LB");

        //User input height, cm or meter.
        heightChoice.getItems().clear();
        heightChoice.setValue("C.M.");
        heightChoice.getItems().addAll("C.M.", "Meter");

        //Special option
        //User number to add calorie burnt for
        calorieUser.getItems().clear();
        calorieUser.setValue(1);
        //Loop to add choices up to 50
        for (int i = 1; i <= 50; i++) {
            calorieUser.getItems().add(i);
        }

        //Weight to be lost
        weightChoice.getItems().clear();
        weightChoice.setValue("KG");
        weightChoice.getItems().addAll("KG", "LB");

        //Calorie view option
        calorieViewType.getItems().clear();
        calorieViewType.setValue("Total Calorie Lost");
        calorieViewType.getItems().addAll("Total Calorie Lost", "Most amount burnt");

        //Exercise selection option
        exerciseChoice.getItems().clear();
        exerciseChoice.setValue("Running");
        exerciseChoice.getItems().addAll("Running", "Cycling");

        //View Info user number
        viewUserNumber.getItems().clear();
        viewUserNumber.setValue(1);
        //Loop to add choices up to 50
        for (int i = 1; i <= 50; i++) {
            viewUserNumber.getItems().add(i);
        }

        //BMI View
        viewInfoType.getItems().clear();
        viewInfoType.setValue("View BMI");
        viewInfoType.getItems().addAll("View BMI", "View Weight Status");
        choiceOfSpeed.setValue("6-7 km/h");
    }

    /**
     * Initialize the choice box to select the speed of exercise
     */
    @FXML
    void exerciseSpeed() {
        if (exerciseChoice.getValue().equals("Running")) {
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
     * Adding an User
     */

    @FXML
    void createUser() {
        try {
            userNumberInt = userNumber.getValue();
            //IF any of the field is empty the program will show an Error.
            if (userName.getText().equals("") || userAge.getText().equals("") || userWeight.getText().equals("") || userHeight.getText().equals("")) {
                leftStatus.setText("Please Enter All Information to Add User");
                leftStatus.setTextFill(Color.RED);
                rightStatus.setText("");
                viewDetails.setText("");
            } else {
                //If the user Already Exists.
                if (userInfo.get(userNumberInt) != null) {
                    leftStatus.setText("User Already Exists. Please Press Change Info");
                    rightStatus.setText("");
                    leftStatus.setTextFill(Color.RED);
                    viewDetails.setText("");
                } else {
                    //Getting the name and gender of the user
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
                            viewDetails.setText("");
                        } else {
                            //Weight Can't be Negative or 0
                            try {
                                //If the option chosen is kilograms
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
                                    viewDetails.setText("");
                                } else {
                                    try {
                                        //If height is cm
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
                                            viewDetails.setText("");
                                        } else {
                                            try {
                                                //Creating the user
                                                user = new User(name, gender, age, weight, height);
                                                userInfo.put(userNumberInt, user);

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
                                        leftStatus.setText("Enter A Positive Number for height");
                                        leftStatus.setTextFill(Color.RED);
                                        rightStatus.setText("");
                                    }
                                }
                            } catch (Exception e) {
                                leftStatus.setText("Enter A Positive Number for weight");
                                leftStatus.setTextFill(Color.RED);
                                rightStatus.setText("");
                            }
                        }
                    } catch (Exception e) {
                        leftStatus.setText("Enter A Positive Number for age");
                        leftStatus.setTextFill(Color.RED);
                        rightStatus.setText("");
                    }
                }
            }
        } catch (Exception e) {
            leftStatus.setText("Please Enter All Information");
            leftStatus.setTextFill(Color.RED);
            rightStatus.setText("");
        }
    }

    @FXML
    void changeUser() {
        try {
            userNumberInt = userNumber.getValue();
            keyCheck = userInfo.containsKey(userNumberInt);
            //IF any of the field is empty the program will show an Error.
            if (userName.getText().equals("") || userAge.getText().equals("") || userWeight.getText().equals("") || userHeight.getText().equals("")) {
                leftStatus.setText("Please Enter All Information To Change Data");
                leftStatus.setTextFill(Color.RED);
                rightStatus.setText("");
                viewDetails.setText("");
            } else {
                if (!keyCheck) {
                    {
                        try {
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
                                    viewDetails.setText("");
                                } else {
                                    //Weight Can't be Negative or 0
                                    try {
                                        //If the option chosen is kilograms
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
                                            viewDetails.setText("");
                                        } else {
                                            try {
                                                //If height is cm
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
                                                    viewDetails.setText("");
                                                } else {
                                                    try {
                                                        //Creating the user
                                                        user = new User(name, gender, age, weight, height);
                                                        userInfo.put(userNumberInt, user);

                                                        leftStatus.setText("");
                                                        rightStatus.setText("User Didn't Exist so Added User! Choose from menu");
                                                        rightStatus.setTextFill(Color.GREEN);
                                                        viewDetails.setText("");
                                                    } catch (Exception e) {
                                                        leftStatus.setText("Couldn't add user");
                                                        leftStatus.setTextFill(Color.RED);
                                                    }
                                                }
                                            } catch (Exception e) {
                                                leftStatus.setText("Enter A Positive Number for height");
                                                leftStatus.setTextFill(Color.RED);
                                                rightStatus.setText("");
                                            }
                                        }
                                    } catch (Exception e) {
                                        leftStatus.setText("Enter A Positive Number for weight");
                                        leftStatus.setTextFill(Color.RED);
                                        rightStatus.setText("");
                                    }
                                }
                            } catch (Exception e) {
                                leftStatus.setText("Enter A Positive Number for age");
                                leftStatus.setTextFill(Color.RED);
                                rightStatus.setText("");
                            }

                        } catch (Exception e) {
                            leftStatus.setText("Please Enter All Information");
                            leftStatus.setTextFill(Color.RED);
                            rightStatus.setText("");
                        }
                    }
                }
                if (keyCheck) {
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
                            viewDetails.setText("");
                        } else {
                            //Weight Can't be Negative or 0
                            try {
                                //If the option chosen is kilograms
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
                                    viewDetails.setText("");
                                } else {
                                    try {
                                        //If height is cm
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
                                            viewDetails.setText("");
                                        } else {
                                            try {
                                                //Creating the user
                                                user = new User(name, gender, age, weight, height);
                                                userInfo.put(userNumberInt, user);
                                                leftStatus.setText("");
                                                rightStatus.setText("Changed Information! Choose from menu");
                                                rightStatus.setTextFill(Color.GREEN);
                                                viewDetails.setText("");
                                            } catch (Exception e) {
                                                leftStatus.setText("Couldn't change user Information");
                                                leftStatus.setTextFill(Color.RED);
                                            }
                                        }
                                    } catch (Exception e) {
                                        leftStatus.setText("Enter A Positive Number for height");
                                        leftStatus.setTextFill(Color.RED);
                                        rightStatus.setText("");
                                    }
                                }
                            } catch (Exception e) {
                                leftStatus.setText("Enter A Positive Number for weight");
                                leftStatus.setTextFill(Color.RED);
                                rightStatus.setText("");
                            }
                        }
                    } catch (Exception e) {
                        leftStatus.setText("Enter A Positive Number for age");
                        leftStatus.setTextFill(Color.RED);
                        rightStatus.setText("");
                    }
                }
            }
        } catch (Exception e) {
            leftStatus.setText("Please Enter All Information");
            leftStatus.setTextFill(Color.RED);
            rightStatus.setText("");
        }
    }

    @FXML
    void addToFile() {

        userNumberInt = userNumber.getValue();
        keyCheck = userInfo.containsKey(userNumberInt);
        if (userName.getText().equals("") || userAge.getText().equals("") || userWeight.getText().equals("") || userHeight.getText().equals("")) {
            leftStatus.setText("Please Enter All Information To Change Data");
            leftStatus.setTextFill(Color.RED);
            rightStatus.setText("");
            viewDetails.setText("");
        } else {
            try {
                String name = userName.getText();
                String age = userAge.getText();
                String gender = String.valueOf(userGender.getValue().charAt(0));
                String weight = userWeight.getText();
                String height = userHeight.getText();

                try {
                    Writer.fileWriter(keyCheck, userNumberInt, name, age, gender, weight, height);
                    leftStatus.setText("User Info added to file!");
                    leftStatus.setTextFill(Color.GREEN);
                    rightStatus.setText("");

                } catch (IOException e) {
                    leftStatus.setText("File cannot be found!");
                    leftStatus.setTextFill(Color.RED);
                    rightStatus.setText("");

                }
            } catch (NullPointerException e) {
                leftStatus.setText("Please Enter All Information");
                leftStatus.setTextFill(Color.RED);
                rightStatus.setText("");
            }
        }
    }


    @FXML
    void viewInfo() {
        try {
            userNumberInt = viewUserNumber.getValue();

            viewDetails.setText(userInfo.get(userNumberInt).toString());
            leftStatus.setText("User Info Printed!");
            leftStatus.setTextFill(Color.GREEN);
            rightStatus.setText("View above");
            rightStatus.setTextFill(Color.GREEN);

        } catch (Exception e) {

            leftStatus.setText("No user found");
            leftStatus.setTextFill(Color.RED);
            rightStatus.setText("Nothing printed");
            rightStatus.setTextFill(Color.RED);

        }
    }

    @FXML
    void viewExercise() {

        String choice = exerciseChoice.getValue();
        String speed = choiceOfSpeed.getValue();

        userNumberInt = viewUserNumber.getValue();
        keyCheck = userInfo.containsKey(userNumberInt);

        try {
            if (keyCheck) {
                user = (User) userInfo.get(userNumberInt);
                weight = user.getUserWeight();

                if (weightExercise.getText().isBlank()) {
                    leftStatus.setText("Invalid Input");
                    leftStatus.setTextFill(Color.RED);
                    rightStatus.setText("Enter valid weight input");
                    rightStatus.setTextFill(Color.RED);

                } else {
                    int weight_loss = Integer.parseInt(weightExercise.getText());


                    int calories = mvh.util.Calculations.estimateCalories(weight_loss);

                    String exercise = mvh.util.Calculations.estimateExercise(speed, choice, calories, weight, weight_loss);
                    viewDetails.setText(exercise);

                    leftStatus.setText("Requested info shown!");
                    leftStatus.setTextFill(Color.GREEN);
                    rightStatus.setText("Check the view box");
                    rightStatus.setTextFill(Color.GREEN);
                }
            } else {
                leftStatus.setText("No user found!");
                leftStatus.setTextFill(Color.RED);
                rightStatus.setText("Enter valid user number");
                rightStatus.setTextFill(Color.RED);
            }
        } catch (NullPointerException e) {
            leftStatus.setText("No user found!");
            leftStatus.setTextFill(Color.RED);
            rightStatus.setText("Input user info");
            rightStatus.setTextFill(Color.RED);
        }
    }

    @FXML
    void viewBMI() {
        userNumberInt = viewUserNumber.getValue();
        keyCheck = userInfo.containsKey(userNumberInt);
        try {
            if (viewInfoType.getValue().equals("View BMI")) {

                if (keyCheck) {

                    user = (User) userInfo.get(userNumberInt);
                    weight = user.getUserWeight();
                    height = user.getUserHeight();

                    viewDetails.setText("Your BMI is " + mvh.util.Calculations.bmi(weight, height));

                    leftStatus.setText("Requested info shown!");
                    leftStatus.setTextFill(Color.GREEN);
                    rightStatus.setText("Check the view box");
                    rightStatus.setTextFill(Color.GREEN);
                } else {
                    leftStatus.setText("No user found!");
                    leftStatus.setTextFill(Color.RED);
                    rightStatus.setText("Enter valid user number");
                    rightStatus.setTextFill(Color.RED);
                }

            } else {
                if (keyCheck) {

                    user = (User) userInfo.get(userNumberInt);
                    weight = user.getUserWeight();
                    height = user.getUserHeight();

                    viewDetails.setText(mvh.util.Calculations.bmiCompare(weight, height));

                    leftStatus.setText("Requested info shown!");
                    leftStatus.setTextFill(Color.GREEN);
                    rightStatus.setText("Check the view box");
                    rightStatus.setTextFill(Color.GREEN);
                } else {
                    leftStatus.setText("No user found!");
                    leftStatus.setTextFill(Color.RED);
                    rightStatus.setText("Enter valid user number");
                    rightStatus.setTextFill(Color.RED);
                }
            }
        } catch (NullPointerException e) {
            leftStatus.setText("No user found!");
            leftStatus.setTextFill(Color.RED);
            rightStatus.setText("Input user info");
            rightStatus.setTextFill(Color.RED);
        }
    }

    @FXML
    void addCalorieBurnt() {

        try {
            String calorie = calorieAmount.getText();
            int userNumber = calorieUser.getValue();

            HashMap<Integer, String> calorieInfo = new HashMap<>();
            calorieInfo.put(userNumber, calorie);

            Writer.writer(userNumber, calorieInfo);
            leftStatus.setText("Calorie added to file!");
            leftStatus.setTextFill(Color.GREEN);

        } catch (IOException e) {
            leftStatus.setText("Cannot be added to file!");
            leftStatus.setTextFill(Color.RED);
            rightStatus.setText("");
        }
    }

    @FXML
    void viewCalorieInfo() {
        userNumberInt = viewUserNumber.getValue();
        keyCheck = userInfo.containsKey(userNumberInt);

        try {
            if (calorieViewType.getValue().equals("Total Calorie Lost")) {
                if (keyCheck) {

                    HashMap<Integer, ArrayList<Integer>> calorieInfo = Reader.outReader();

                    int totalCalories = mvh.util.Calculations.getTotalCalories(userNumberInt, calorieInfo);

                    viewDetails.setText("Total calories lost " + totalCalories);
                    leftStatus.setText("Requested info shown!");
                    leftStatus.setTextFill(Color.GREEN);
                    rightStatus.setText("Check the view box");
                    rightStatus.setTextFill(Color.GREEN);

                } else {
                    leftStatus.setText("No user found!");
                    leftStatus.setTextFill(Color.RED);
                    rightStatus.setText("Enter valid user number");
                    rightStatus.setTextFill(Color.RED);
                }
            } else {
                if (keyCheck) {

                    HashMap<Integer, ArrayList<Integer>> calorieInfo = Reader.outReader();

                    int maxCalories = mvh.util.Calculations.getMaxCalories(userNumberInt, calorieInfo);
                    viewDetails.setText("Max calories lost in a day " + maxCalories);
                    leftStatus.setText("Requested info shown!");
                    leftStatus.setTextFill(Color.GREEN);
                    rightStatus.setText("Check the view box");
                    rightStatus.setTextFill(Color.GREEN);

                } else {
                    leftStatus.setText("No user found!");
                    leftStatus.setTextFill(Color.RED);
                    rightStatus.setText("Enter valid user number");
                    rightStatus.setTextFill(Color.RED);
                }
            }
        } catch (IOException e) {
            leftStatus.setText("No user found!");
            leftStatus.setTextFill(Color.RED);
            rightStatus.setText("Enter correct user number");
            rightStatus.setTextFill(Color.RED);
        }
    }

    @FXML
    void loadButton() {
        //File chooser setup
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        File file = fileChooser.showOpenDialog(null);

        try {
            Reader.reader(file);
            leftStatus.setText("User info read from file");
            leftStatus.setTextFill(Color.GREEN);
            rightStatus.setText("");

        } catch (IOException e) {
            leftStatus.setText("File cannot be read!");
            leftStatus.setTextFill(Color.RED);
            rightStatus.setText("Choose a new file");
            rightStatus.setTextFill(Color.RED);
        }
    }

    @FXML
    void saveButton() {
        //File chooser setup
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.setInitialFileName("UserInfo.txt");
        File fileSave = fileChooser.showSaveDialog(new Stage());
        System.out.println(fileSave);

        //Surrounding with a try/catch to handle exceptions
        //Calling the writer to write the world information in it
        try {
            leftStatus.setText("User file saved successfully!");
            leftStatus.setTextFill(Color.GREEN);
            rightStatus.setText("User info saved");
            rightStatus.setTextFill(Color.GREEN);

            //Catching exception
        } catch (Exception e) {
            leftStatus.setText("File couldn't be created");
            leftStatus.setTextFill(Color.RED);
            rightStatus.setText("File not saved!");
            leftStatus.setTextFill(Color.RED);
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
}
