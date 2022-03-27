package Test;

import Util.Reader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

//    @Test
//    void Reader_test1() throws IOException {
//
//        //Expected Result
//        String expResult = ""
//                + "[User Name: Fabiha\n"
//                + "Gender: F\n"
//                + "Age: 19.0\n"
//                + "Weight in Kgs: 30.0\n"
//                + "Height in centimeters: 156.0\n"
//                + "]\n";
//
//        String actResult = ;
//
//        assertEquals(expResult,actResult);
//    }

    @Test
    void outReader_test() throws IOException {
        ArrayList<String> outInfo = new ArrayList<>();
        outInfo.add("100");
        outInfo.add("10");
        outInfo.add("10");

        ArrayList<String> expResult = outInfo;
        ArrayList<String> actResult = Reader.outReader();

        assertEquals(expResult, actResult);

    }

    @Test
    void bmi_test1() {
        double weight = 56;
        double height = 156;

        String expResult = "23.01";
        String actResult = Main.Calculations.bmi(weight, height);
        assertEquals(expResult,actResult);
    }

    @Test
    void bmi_test2(){
        double weight = 40;
        double height = 170;

        String expResult = "13.84";
        String actResult = Main.Calculations.bmi(weight, height);
        assertEquals(expResult,actResult);
    }

    @Test
    void bmi_test3(){
        double weight = 79;
        double height = 168;

        String expResult = "27.99";
        String actResult = Main.Calculations.bmi(weight, height);
        assertEquals(expResult,actResult);
    }

    @Test
    void bmi_test4(){
        double weight = 89;
        double height = 169;

        String expResult = "31.16";
        String actResult = Main.Calculations.bmi(weight, height);
        assertEquals(expResult,actResult);
    }

    @Test
    void bmiCompare_test1() {
        double weight = 56;
        double height = 156;

        String expResult = "You are normal";
        String actResult = Main.Calculations.bmiCompare(weight, height);
        assertEquals(expResult, actResult);
    }

    @Test
    void bmiCompare_test2(){
        double weight = 40;
        double height = 170;

        String expResult = "You are underweight";
        String actResult = Main.Calculations.bmiCompare(weight, height);
        assertEquals(expResult, actResult);
    }

    @Test
    void bmiCompare_test3(){
        double weight = 79;
        double height = 168;

        String expResult = "You are overweight";
        String actResult = Main.Calculations.bmiCompare(weight, height);
        assertEquals(expResult, actResult);
    }

    @Test
    void bmiCompare_test4(){
        double weight = 89;
        double height = 169;

        String expResult = "You are obese";
        String actResult = Main.Calculations.bmiCompare(weight, height);
        assertEquals(expResult, actResult);
    }

    @Test
    void estimateCalories_test1() {
        int kg_input = 2;

        int expResult = 15400;
        int actResult = Main.Calculations.estimateCalories(kg_input);
        assertEquals(expResult, actResult);
    }

    @Test
    void estimateCalories_test2(){
        int kg_input = 6;

        int expResult = 46200;
        int actResult = Main.Calculations.estimateCalories(kg_input);
        assertEquals(expResult, actResult);
    }

    @Test
    void getTotalCalories_test1() {
        ArrayList<String> calories = new ArrayList<>();
        calories.add("10");
        calories.add("100");
        calories.add("2000");

        int expResult = 2110;
        int actResult = Main.Calculations.getTotalCalories(calories);
        assertEquals(expResult, actResult);

    }

    @Test
    void getTotalCalories_test2() {
        ArrayList<String> calories = new ArrayList<>();
        calories.add("7000");
        calories.add("100");
        calories.add("1900");

        int expResult = 9000;
        int actResult = Main.Calculations.getTotalCalories(calories);
        assertEquals(expResult, actResult);

    }

    @Test
    void getTotalCalories_test3() {
        ArrayList<String> calories = new ArrayList<>();
        calories.add("780");
        calories.add("310");
        calories.add("420");

        int expResult = 1510;
        int actResult = Main.Calculations.getTotalCalories(calories);
        assertEquals(expResult, actResult);
    }


}