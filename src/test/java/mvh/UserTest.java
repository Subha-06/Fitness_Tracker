package mvh;

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
        HashMap<Integer, ArrayList<Integer>> actResult = new HashMap<>();
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
        HashMap<Integer, ArrayList<Integer>> actResult = new HashMap<>();
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
        HashMap<Integer, ArrayList<Integer>> actResult = new HashMap<>();
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
        HashMap<Integer, ArrayList<Integer>> actResult = new HashMap<>();
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
        HashMap<Integer, ArrayList<Integer>> actResult = new HashMap<>();
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
        HashMap<Integer, ArrayList<Integer>> actResult = new HashMap<>();
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

//    /**
//     * Calculate the number of calories one person has burnt
//     */
//
//    @Test
//    void getTotalCalories_test1() {
//        //Creating a new arraylist to pass in to the function
//        ArrayList<String> calories = new ArrayList<>();
//        calories.add("10");
//        calories.add("100");
//        calories.add("2000");
//        //Expected total calories burnt
//        int expResult = 2110;
//        //Calling the function with the values passed in and getting the result
//        int actResult = Calculations.getTotalCalories(calories);
//        //Comparing the result
//        assertEquals(expResult, actResult);
//
//    }
//
//    @Test
//    void getTotalCalories_test2() {
//        //Creating a new arraylist to pass in to the function
//        ArrayList<String> calories = new ArrayList<>();
//        calories.add("7000");
//        calories.add("100");
//        calories.add("1900");
//        //Expected total calories burnt
//        int expResult = 9000;
//        //Calling the function with the values passed in and getting the result
//        int actResult = Calculations.getTotalCalories(calories);
//        //Comparing the result
//        assertEquals(expResult, actResult);
//
//    }
//
//    @Test
//    void getTotalCalories_test3() {
//        //Creating a new arraylist to pass in to the function
//        ArrayList<String> calories = new ArrayList<>();
//        calories.add("780");
//        calories.add("310");
//        calories.add("420");
//        //Expected total calories burnt
//        int expResult = 1510;
//        //Calling the function with the values passed in and getting the result
//        int actResult = Calculations.getTotalCalories(calories);
//        //Comparing the result
//        assertEquals(expResult, actResult);
//    }


}
