///**
// * A fitness tracking program that allows the user to input their information and get back various results form that
// * *Members:
// * Fabiha Fairuzz Subha (UCID: 30148674)
// * Amasil Rahim Zihad (UCID: 30164830)
// * * Date: 1 March 2022
// * * Demo 2 Tutorial 05
// */
//package Test;
//
//import Util.Reader;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class UserTest {
//
//    /***
//     * Testing the out reader function which returns an arraylist with calorie burnt.
//     */
//    @Test
//    void outReader_test() throws IOException {
//        //Creating the test arraylist to match to
//        ArrayList<String> outInfo = new ArrayList<>();
//        outInfo.add("100");
//        outInfo.add("10");
//        outInfo.add("10");
//        //Calling the reader function to read the file and getting the result
//        ArrayList<String> actResult = Reader.outReader();
//        //Compare the two arraylist
//        assertEquals(outInfo, actResult);
//
//    }
//
//    /**
//     * Tests the bmi calculator function. The values passed will be the users weight and height
//     */
//    @Test
//    void bmi_test1() {
//        //The values to pass in to the function
//        double weight = 56;
//        double height = 156;
//        //Actual expected result
//        String expResult = "23.01";
//        //Calling the function with the values passed in and getting the result
//        String actResult = Main.Calculations.bmi(weight, height);
//        //Comparing the result
//        assertEquals(expResult, actResult);
//    }
//
//    @Test
//    void bmi_test2() {
//        //The values to pass in to the function
//        double weight = 40;
//        double height = 170;
//        //Actual expected result
//        String expResult = "13.84";
//        //Calling the function with the values passed in and getting the result
//        String actResult = Main.Calculations.bmi(weight, height);
//        //Comparing the result
//        assertEquals(expResult, actResult);
//    }
//
//    @Test
//    void bmi_test3() {
//        //The values to pass in to the function
//        double weight = 79;
//        double height = 168;
//        //Actual expected result
//        String expResult = "27.99";
//        //Calling the function with the values passed in and getting the result
//        String actResult = Main.Calculations.bmi(weight, height);
//        //Comparing the result
//        assertEquals(expResult, actResult);
//    }
//
//    @Test
//    void bmi_test4() {
//        //The values to pass in to the function
//        double weight = 89;
//        double height = 169;
//        //Actual expected result
//        String expResult = "31.16";
//        //Calling the function with the values passed in and getting the result
//        String actResult = Main.Calculations.bmi(weight, height);
//        //Comparing the result
//        assertEquals(expResult, actResult);
//    }
//
//    /**
//     * Test for bmi comparison
//     */
//    @Test
//    void bmiCompare_test1() {
//        //The values to pass in to the function
//        double weight = 56;
//        double height = 156;
//        //Actual expected result
//        String expResult = "You are normal";
//        //Calling the function with the values passed in and getting the result
//        String actResult = Main.Calculations.bmiCompare(weight, height);
//        //Comparing the result
//        assertEquals(expResult, actResult);
//    }
//
//    @Test
//    void bmiCompare_test2() {
//        //The values to pass in to the function
//        double weight = 40;
//        double height = 170;
//        //Actual expected result
//        String expResult = "You are underweight";
//        //Calling the function with the values passed in and getting the result
//        String actResult = Main.Calculations.bmiCompare(weight, height);
//        //Comparing the result
//        assertEquals(expResult, actResult);
//    }
//
//    @Test
//    void bmiCompare_test3() {
//        //The values to pass in to the function
//        double weight = 79;
//        double height = 168;
//        //Actual expected result
//        String expResult = "You are overweight";
//        //Calling the function with the values passed in and getting the result
//        String actResult = Main.Calculations.bmiCompare(weight, height);
//        //Comparing the result
//        assertEquals(expResult, actResult);
//    }
//
//    @Test
//    void bmiCompare_test4() {
//        //The values to pass in to the function
//        double weight = 89;
//        double height = 169;
//        //Actual expected result
//        String expResult = "You are obese";
//        //Calling the function with the values passed in and getting the result
//        String actResult = Main.Calculations.bmiCompare(weight, height);
//        //Comparing the result
//        assertEquals(expResult, actResult);
//    }
//
//    /**
//     * Test to see the estimate calorie burnt to reach the weight goal
//     */
//    @Test
//    void estimateCalories_test1() {
//        //The weight goal
//        int kg_input = 2;
//        //Expected calories to reach that goal
//        int expResult = 15400;
//        //Calling the function with the values passed in and getting the result
//        int actResult = Main.Calculations.estimateCalories(kg_input);
//        //Comparing the result
//        assertEquals(expResult, actResult);
//    }
//
//    @Test
//    void estimateCalories_test2() {
//        //The weight goal
//        int kg_input = 6;
//        //Expected calories to reach that goal
//        int expResult = 46200;
//        //Calling the function with the values passed in and getting the result
//        int actResult = Main.Calculations.estimateCalories(kg_input);
//        //Comparing the result
//        assertEquals(expResult, actResult);
//    }
//
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
//        int actResult = Main.Calculations.getTotalCalories(calories);
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
//        int actResult = Main.Calculations.getTotalCalories(calories);
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
//        int actResult = Main.Calculations.getTotalCalories(calories);
//        //Comparing the result
//        assertEquals(expResult, actResult);
//    }
//
//
//}
