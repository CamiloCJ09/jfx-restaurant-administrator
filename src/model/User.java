package model;

import java.io.Serializable;

public class User extends Employee implements Serializable {

    public final static long serialVersionUID = 1;

    //Attributes
    private String userName;
    private String password;

    //Methods
    public User(User creator, User modifier, String firstName, String lastName, String id, String userName, String password) {
        super(creator, modifier, firstName, lastName, id);
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
