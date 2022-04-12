package mvh;

import mvh.user.User;
import mvh.util.Reader;
import mvh.util.Calculations;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 1 March 2022
 * * Demo 2 Tutorial 05
 */

class UserTest {

    /***
     * Testing the out reader function which returns an arraylist with calorie burnt.
     */
    @Test
    void outReader_test() throws IOException {
        //Creating the test arraylist to match to
        File outFile = new File("ReaderTest.txt");
        HashMap<Integer, ArrayList<Integer>> expResult = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> actResult;
        ArrayList<Integer> outInfo = new ArrayList<>();
        outInfo.add(1);
        outInfo.add(12);
        expResult.put(1, outInfo);
        //Calling the reader function to read the file and getting the result
        actResult = Reader.outReader(1, outFile);
        //Compare the two arraylist
        assertEquals(actResult, expResult);

    }

    /***
     * Testing the out reader function which returns an arraylist with calorie burnt.
     */
    @Test
    void outReader_test1() throws IOException {
        //Creating the test arraylist to match to
        File outFile = new File("ReaderTest.txt");
        HashMap<Integer, ArrayList<Integer>> expResult = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> actResult;
        ArrayList<Integer> outInfo = new ArrayList<>();
        outInfo.add(1);
        outInfo.add(12);
        expResult.put(2, outInfo);
        //Calling the reader function to read the file and getting the result
        actResult = Reader.outReader(2, outFile);
        //Compare the two arraylist
        assertEquals(actResult, expResult);
    }

    /***
     * Testing the out reader function which returns an arraylist with calorie burnt.
     */
    @Test
    void outReader_test2() throws IOException {
        //Creating the test arraylist to match to
        File outFile = new File("ReaderTest.txt");
        HashMap<Integer, ArrayList<Integer>> expResult = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> actResult;
        ArrayList<Integer> outInfo = new ArrayList<>();
        outInfo.add(15);
        outInfo.add(16);
        outInfo.add(17);
        outInfo.add(18);
        expResult.put(3, outInfo);
        //Calling the reader function to read the file and getting the result
        actResult = Reader.outReader(3, outFile);
        //Compare the two arraylist
        assertEquals(actResult, expResult);
    }

    /***
     * Testing the out reader function which returns an arraylist with calorie burnt.
     */
    @Test
    void outReader_test3() throws IOException {
        //Creating the test arraylist to match to
        File outFile = new File("ReaderTest.txt");
        HashMap<Integer, ArrayList<Integer>> expResult = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> actResult;
        ArrayList<Integer> outInfo = new ArrayList<>();
        outInfo.add(500);
        outInfo.add(100);
        outInfo.add(1000);
        outInfo.add(2000);
        expResult.put(4, outInfo);
        //Calling the reader function to read the file and getting the result
        actResult = Reader.outReader(4, outFile);
        //Compare the two arraylist
        assertEquals(actResult, expResult);
    }

    /***
     * Testing the out reader function which returns an arraylist with calorie burnt.
     */
    @Test
    void outReader_test4() throws IOException {
        //Creating the test arraylist to match to
        File outFile = new File("ReaderTest.txt");
        HashMap<Integer, ArrayList<Integer>> expResult = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> actResult;
        ArrayList<Integer> outInfo = new ArrayList<>();
        outInfo.add(150);
        outInfo.add(200);
        outInfo.add(250);
        outInfo.add(300);
        expResult.put(7, outInfo);
        //Calling the reader function to read the file and getting the result
        actResult = Reader.outReader(7, outFile);
        //Compare the two arraylist
        assertEquals(actResult, expResult);
    }

    /***
     * Testing the out reader function which returns an arraylist with calorie burnt.
     */
    @Test
    void outReader_test5() throws IOException {
        //Creating the test arraylist to match to
        File outFile = new File("ReaderTest.txt");
        HashMap<Integer, ArrayList<Integer>> expResult = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> actResult;
        ArrayList<Integer> outInfo = new ArrayList<>();
        outInfo.add(2500);
        outInfo.add(3000);
        outInfo.add(3500);
        outInfo.add(4000);
        outInfo.add(4500);
        expResult.put(9, outInfo);
        //Calling the reader function to read the file and getting the result
        actResult = Reader.outReader(9, outFile);
        //Compare the two arraylist
        assertEquals(actResult, expResult);
    }

    /**
     * Tests the bmi calculator function. The values passed will be the users weight and height
     */
    @Test
    void bmi_test1() {
        //The values to pass in to the function
        double weight = 56;
        double height = 156;
        //Actual expected result
        String expResult = "23.01";
        //Calling the function with the values passed in and getting the result
        String actResult = Calculations.bmi(weight, height);
        //Comparing the result
        assertEquals(expResult, actResult);
    }

    /**
     * * Tests the bmi calculator function. The values passed will be the users weight and height
     */
    @Test
    void bmi_test2() {
        //The values to pass in to the function
        double weight = 40;
        double height = 170;
        //Actual expected result
        String expResult = "13.84";
        //Calling the function with the values passed in and getting the result
        String actResult = Calculations.bmi(weight, height);
        //Comparing the result
        assertEquals(expResult, actResult);
    }

    /**
     * * Tests the bmi calculator function. The values passed will be the users weight and height
     */
    @Test
    void bmi_test3() {
        //The values to pass in to the function
        double weight = 79;
        double height = 168;
        //Actual expected result
        String expResult = "27.99";
        //Calling the function with the values passed in and getting the result
        String actResult = Calculations.bmi(weight, height);
        //Comparing the result
        assertEquals(expResult, actResult);
    }

    /**
     * * Tests the bmi calculator function. The values passed will be the users weight and height
     */
    @Test
    void bmi_test4() {
        //The values to pass in to the function
        double weight = 89;
        double height = 169;
        //Actual expected result
        String expResult = "31.16";
        //Calling the function with the values passed in and getting the result
        String actResult = Calculations.bmi(weight, height);
        //Comparing the result
        assertEquals(expResult, actResult);
    }

    /**
     * Test for bmi comparison
     */
    @Test
    void bmiCompare_test1() {
        //The values to pass in to the function
        double weight = 56;
        double height = 156;
        //Actual expected result
        String expResult = "Normal";
        //Calling the function with the values passed in and getting the result
        String actResult = Calculations.bmiCompare(weight, height);
        //Comparing the result
        assertEquals(expResult, actResult);
    }

    /**
     * Test for bmi comparison
     */
    @Test
    void bmiCompare_test2() {
        //The values to pass in to the function
        double weight = 40;
        double height = 170;
        //Actual expected result
        String expResult = "Underweight";
        //Calling the function with the values passed in and getting the result
        String actResult = Calculations.bmiCompare(weight, height);
        //Comparing the result
        assertEquals(expResult, actResult);
    }

    /**
     * Test for bmi comparison
     */
    @Test
    void bmiCompare_test3() {
        //The values to pass in to the function
        double weight = 79;
        double height = 168;
        //Actual expected result
        String expResult = "Overweight";
        //Calling the function with the values passed in and getting the result
        String actResult = Calculations.bmiCompare(weight, height);
        //Comparing the result
        assertEquals(expResult, actResult);
    }

    /**
     * Test for bmi comparison
     */
    @Test
    void bmiCompare_test4() {
        //The values to pass in to the function
        double weight = 89;
        double height = 169;
        //Actual expected result
        String expResult = "Obese";
        //Calling the function with the values passed in and getting the result
        String actResult = Calculations.bmiCompare(weight, height);
        //Comparing the result
        assertEquals(expResult, actResult);
    }

    /**
     * Test to see the estimate calorie burnt to reach the weight goal
     */
    @Test
    void estimateCalories_test1() {
        //The weight goal
        int kg_input = 2;
        //Expected calories to reach that goal
        int expResult = 15400;
        //Calling the function with the values passed in and getting the result
        int actResult = (int) Calculations.estimateCalories(kg_input);
        //Comparing the result
        assertEquals(expResult, actResult);
    }

    /**
     * Test to see the estimate calorie burnt to reach the weight goal
     */
    @Test
    void estimateCalories_test2() {
        //The weight goal
        int kg_input = 6;
        //Expected calories to reach that goal
        int expResult = 46200;
        //Calling the function with the values passed in and getting the result
        int actResult = (int) Calculations.estimateCalories(kg_input);
        //Comparing the result
        assertEquals(expResult, actResult);
    }

    /**
     * Test to see the hours spent doing exercise to reach the weight goal
     */
    @Test
    void estimateExercise_test1() {

        //Setting the variables for the test
        String speed = "16-19 km/h";
        String exercise = "Cycling";
        double weight = 70;
        double goal = 50;
        double diff = weight - goal;
        double calories = Calculations.estimateCalories(diff);

        String expResult = """
                You need to cycle 349.2 hours
                at 16-19 km/h to burn 154000.0 calories
                and lose 20.0 kgs to reach\s
                the weight goal of 50.0 kgs""";
        String actResult = Calculations.estimateExercise(speed,exercise,calories,weight,diff,goal);
        assertEquals(expResult,actResult);
    }

    /**
     * Test to see the hours spent doing exercise to reach the weight goal
     */
    @Test
    void estimateExercise_test2() {

        //Setting the variables for the test
        String speed = "22-25 km/h";
        String exercise = "Cycling";
        double weight = 60;
        double goal = 45;
        double diff = weight - goal;
        double calories = Calculations.estimateCalories(diff);

        String expResult = """
                You need to cycle 183.3 hours
                at 22-25 km/h to burn 115500.0 calories
                and lose 15.0 kgs to reach\s
                the weight goal of 45.0 kgs""";
        String actResult = Calculations.estimateExercise(speed,exercise,calories,weight,diff,goal);
        assertEquals(expResult,actResult);
    }

    /**
     * Test to see the hours spent doing exercise to reach the weight goal
     */
    @Test
    void estimateExercise_test3() {

        //Setting the variables for the test
        String speed = "6-7 km/h";
        String exercise = "Running";
        double weight = 56;
        double goal = 50;
        double diff = weight - goal;
        double calories = Calculations.estimateCalories(diff);

        String expResult = """
                You need to run 157.1 hours
                at 6-7 km/h to burn 46200.0 calories
                and lose 6.0 kgs to reach\s
                the weight goal of 50.0 kgs""";
        String actResult = Calculations.estimateExercise(speed,exercise,calories,weight,diff,goal);
        assertEquals(expResult,actResult);
    }

    /**
     * Test to see the hours spent doing exercise to reach the weight goal
     */
    @Test
    void estimateExercise_test4() {

        //Setting the variables for the test
        String speed = "9-11 km/h";
        String exercise = "Running";
        double weight = 80;
        double goal = 56;
        double diff = weight - goal;
        double calories = Calculations.estimateCalories(diff);

        String expResult = """
                You need to run 200.0 hours
                at 9-11 km/h to burn 184800.0 calories
                and lose 24.0 kgs to reach\s
                the weight goal of 56.0 kgs""";
        String actResult = Calculations.estimateExercise(speed,exercise,calories,weight,diff,goal);
        assertEquals(expResult,actResult);
    }

    /**
     * Test to see the estimate calorie burnt to reach the weight goal
     */
    @Test
    void getTotalCalories_test1() {
        //Creating a new arraylist to pass in to the function
        int keyNumber = 1;
        HashMap<Integer,ArrayList<Integer>> calories = new HashMap<>();
        ArrayList<Integer> cal = new ArrayList<>();
        cal.add(100); cal.add(160); cal.add(40);

        calories.put(keyNumber,cal);
        //Expected total calories burnt
        int expResult = 300;
        //Calling the function with the values passed in and getting the result
        int actResult = Calculations.getTotalCalories(keyNumber,calories);
        //Comparing the result
        assertEquals(expResult, actResult);

    }

    /**
     * Test to see the estimate calorie burnt to reach the weight goal
     */
    @Test
    void getTotalCalories_test2() {
        //Creating a new arraylist to pass in to the function
        int keyNumber = 5;
        HashMap<Integer,ArrayList<Integer>> calories = new HashMap<>();
        ArrayList<Integer> cal = new ArrayList<>();
        cal.add(7000); cal.add(100); cal.add(1900);

        calories.put(keyNumber,cal);
        //Expected total calories burnt
        int expResult = 9000;
        //Calling the function with the values passed in and getting the result
        int actResult = Calculations.getTotalCalories(keyNumber,calories);
        //Comparing the result
        assertEquals(expResult, actResult);

    }

    /**
     * Test to see the estimate calorie burnt to reach the weight goal
     */
    @Test
    void getTotalCalories_test3() {
        //Creating a new arraylist to pass in to the function
        int keyNumber = 5;
        HashMap<Integer,ArrayList<Integer>> calories = new HashMap<>();
        ArrayList<Integer> cal = new ArrayList<>();
        cal.add(7000); cal.add(100); cal.add(1900);

        calories.put(keyNumber,cal);
        //Expected total calories burnt
        int expResult = 0;
        //Calling the function with the values passed in and getting the result
        int actResult = Calculations.getTotalCalories(1,calories);
        //Comparing the result
        assertEquals(expResult, actResult);

    }

    /**
     * Test to see the maximum calories a user has burnt
     */
    @Test
    void getMaxCalories_test1(){
        int keyNumber = 5;
        HashMap<Integer,ArrayList<Integer>> calories = new HashMap<>();
        ArrayList<Integer> cal = new ArrayList<>();

        cal.add(7000); cal.add(100); cal.add(1900);

        calories.put(keyNumber,cal);
        //Expected total calories burnt
        int expResult = 7000;
        //Calling the function with the values passed in and getting the result
        int actResult = Calculations.getMaxCalories(keyNumber,calories);
        //Comparing the result
        assertEquals(expResult, actResult);
    }

    /**
     * Test to see the maximum calories a user has burnt
     */
    @Test
    void getMaxCalories_test2(){
        int keyNumber = 5;
        HashMap<Integer,ArrayList<Integer>> calories = new HashMap<>();
        ArrayList<Integer> cal = new ArrayList<>();

        cal.add(100); cal.add(160); cal.add(40);

        calories.put(keyNumber,cal);
        //Expected total calories burnt
        int expResult = 160;
        //Calling the function with the values passed in and getting the result
        int actResult = Calculations.getMaxCalories(keyNumber,calories);
        //Comparing the result
        assertEquals(expResult, actResult);
    }

    /**
     * Test to if the string is getting printed correctly
     */
    @Test
    void toString_test1(){
        //Setting the variables for creating the string output
        String name = "Subha";
        String gender = "Female";
        double age = 19;
        double weight = 45;
        double height = 156;

        //Creating a new user
        User user = new User(name,gender,age,weight,height);
        String actResult = user.toString();

        String expResult = """
                Name: Subha\s
                Gender: Female\s
                Age: 19\s
                Weight in Kgs: 45.0\s
                Height in centimeters: 156.0\s
                """;
        assertEquals(expResult, actResult);
    }

    /**
     * Test to if the string is getting printed correctly
     */
    @Test
    void toString_test2(){
        //Setting the variables for creating the string output
        String name = "Amasil";
        String gender = "Male";
        double age = 21;
        double weight = 50;
        double height = 170;

        //Creating a new user
        User user = new User(name,gender,age,weight,height);
        String actResult = user.toString();

        String expResult = """
                Name: Amasil\s
                Gender: Male\s
                Age: 21\s
                Weight in Kgs: 50.0\s
                Height in centimeters: 170.0\s
                """;
        assertEquals(expResult, actResult);
    }
}
