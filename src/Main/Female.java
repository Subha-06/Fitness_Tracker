package Main;

public class Female extends User{

    public Female(String name, String gender, double age, double weight, double height){
        super(name, gender, age, weight, height);

    }

    public  String toString(){
        return String.format("""
                User Name: %s\s
                 Gender: %s\s
                 Age: %s\s
                 Weight in Kgs: %s\s
                 Height in centimeters: %s\s
                """, userName, userGender, userAge, userWeight, userHeight);
    }

}
