import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {


    @Test
    void BMITest_1() {
        double weight = 56;
        double height = 1.56;

        String expResult = "23.01";
        String actResult = Main.bmi(weight, height);
        assertEquals(expResult, actResult);
    }

    @Test
    void BMITest_2() {
        double weight = 40;
        double height = 1.70;

        String expResult = "13.84";
        String actResult = Main.bmi(weight, height);
        assertEquals(expResult, actResult);
    }

    @Test
    void BMITest_3() {
        double weight = 79;
        double height = 1.68;

        String expResult = "27.99";
        String actResult = Main.bmi(weight, height);
        assertEquals(expResult, actResult);
    }

    @Test
    void BMITest_4() {
        double weight = 89;
        double height = 1.69;

        String expResult = "31.16";
        String actResult = Main.bmi(weight, height);
        assertEquals(expResult, actResult);
    }


    //    @Test
//    void BMI_CompareTest_1() {
//        double weight = ;
//        double height = ;
//
//        String BMI = "23.01";
//
//
//        String expResult = "You are normal weight";
//        String actResult = Main.bmicompare();
//        assertEquals(expResult, actResult);
//    }
    @Test
    void BMI_CompareTest_2() {
        double weight = 50;
        double height = 1.83;
        String BMI = "14.93";

        String expResult = "You are underweight";
        String actResult = Main.bmi(weight, height);
        assertEquals(expResult, actResult);
    }

    @Test
    void BMI_CompareTest_3() {
        double weight = 100;
        double height = 1.83;
        String BMI = "29.86";

        String expResult = "You are overweight";
        String actResult = Main.bmi(weight, height);
        assertEquals(expResult, actResult);
    }

    @Test
    void BMI_CompareTest_4() {
        double weight = 120;
        double height = 1.83;
        String BMI = "35.83";

        String expResult = "You are obese";
        String actResult = Main.bmi(weight, height);
        assertEquals(expResult, actResult);
    }

    @Test
    void BMI_CompareTest_5() {
        double weight = 70;
        double height = 1.83;
        String BMI = "20.90";

        String expResult = "You are normal";
        String actResult = Main.bmi(weight, height);
        assertEquals(expResult, actResult);
    }


    @Test
    void estimateCaloriesTest_1() {
        int kg_input = 2;

        int expResult = 15400;
        int actResult = Main.estimateCalories(kg_input);
        assertEquals(expResult, actResult);
    }

    @Test
    void estimateCaloriesTest_2() {
        int kg_input = 6;

        int expResult = 46200;
        int actResult = Main.estimateCalories(kg_input);
        assertEquals(expResult, actResult);
    }

    @Test
    void estimateCaloriesTest_3() {
        int kg_input = 10;

        int expResult = 77000;
        int actResult = Main.estimateCalories(kg_input);
        assertEquals(expResult, actResult);
    }

    @Test
    void estimateCaloriesTest_4() {
        int kg_input = 9;

        int expResult = 69300;
        int actResult = Main.estimateCalories(kg_input);
        assertEquals(expResult, actResult);
    }


}