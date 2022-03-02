import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {


    @Test
    void BMITest_1() {
        double weight = 56;
        double height = 1.56;

        String expResult = "23.01";
        String actResult = Main.bmi(weight, height);
        assertEquals(expResult,actResult);
    }
    @Test
    void BMITest_2() {
        double weight = 40;
        double height = 1.70;

        String expResult = "13.84";
        String actResult = Main.bmi(weight, height);
        assertEquals(expResult,actResult);
    }
    @Test
    void BMITest_3() {
        double weight = 79;
        double height = 1.68;

        String expResult = "27.99";
        String actResult = Main.bmi(weight, height);
        assertEquals(expResult,actResult);
    }
    @Test
    void BMITest_4() {
        double weight = 89;
        double height = 1.69;

        String expResult = "31.16";
        String actResult = Main.bmi(weight, height);
        assertEquals(expResult,actResult);
    }


    @Test
    void BMI_CompareTest_1() {
        String BMI = "23.01";

        String expResult = "You are normal weight";
        String actResult = Project.BMI_Compare(BMI);
        assertEquals(expResult, actResult);
    }
    @Test
    void BMI_CompareTest_2() {
        String BMI = "13.84";

        String expResult = "You are underweight";
        String actResult = Main.bmi(BMI);
        assertEquals(expResult, actResult);
    }
    @Test
    void BMI_CompareTest_3() {
        String BMI = "27.99";

        String expResult = "You are overweight";
        String actResult = Project.BMI_Compare(BMI);
        assertEquals(expResult, actResult);
    }
    @Test
    void BMI_CompareTest_4() {
        String BMI = "31.16";

        String expResult = "You are obese";
        String actResult = Project.BMI_Compare(BMI);
        assertEquals(expResult, actResult);
    }


    @Test
    void estimateCaloriesTest_1() {
        int kg_input = 2;

        int expResult = 15400;
        int actResult = Project.estimateCalories(kg_input);
        assertEquals(expResult, actResult);
    }
    @Test
    void estimateCaloriesTest_2() {
        int kg_input = 6;

        int expResult = 46200;
        int actResult = Project.estimateCalories(kg_input);
        assertEquals(expResult, actResult);
    }
    @Test
    void estimateCaloriesTest_3() {
        int kg_input = 10;

        int expResult = 77000;
        int actResult = Project.estimateCalories(kg_input);
        assertEquals(expResult, actResult);
    }
    @Test
    void estimateCaloriesTest_4() {
        int kg_input = 9;

        int expResult = 69300;
        int actResult = Project.estimateCalories(kg_input);
        assertEquals(expResult, actResult);
    }



    @Test
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void main() {
    }

    @org.junit.jupiter.api.Test
    void getuserinput() {
    }

    @org.junit.jupiter.api.Test
    void getuserchoice() {
    }

    @org.junit.jupiter.api.Test
    void printinfo() {
    }

    @org.junit.jupiter.api.Test
    void reenter() {
    }

    @org.junit.jupiter.api.Test
    void bmi() {
    }

    @org.junit.jupiter.api.Test
    void bmicompare() {
    }

    @org.junit.jupiter.api.Test
    void estimateCalories() {
    }

    @org.junit.jupiter.api.Test
    void estimateExercise() {
    }
}