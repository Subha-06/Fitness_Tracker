package Main;

public class User {

    private String userName;
    private String userGender;
    private int userAge;
    private int userWeight;
    private int userHeight;

    //Getter
    public String getUserName(){
        return userName;
    }

    public String getUserGender(){
        return userGender;
    }

    public int getUserAge(){
        return userAge;
    }

    public int getUserWeight(){
        return userWeight;
    }

    public int getUserHeight(){
        return userHeight;
    }

    //Setter
    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setUserGender(String userGender){
        this.userGender = userGender;
    }

    public void setUserAge(int userAge){
        this.userAge = userAge;
    }

    public void setUserWeight(int userWeight){
        this.userWeight = userWeight;
    }

    public void setUserHeight(int userHeight){
        this.userHeight = userHeight;
    }
}
