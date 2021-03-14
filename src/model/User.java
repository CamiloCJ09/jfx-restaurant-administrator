package model;

public class User extends Employee{
    //Attributes
    private String userName;
    private String password;

    //Methods
    public User(String firstName, String lastName, String id, String userName, String password) {
        super(firstName, lastName, id);
        this.userName = userName;
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
