package model;

public class Employee extends Person {

    public Employee(User creator, User modifier, String firstName, String lastName, String id){
        super(creator, modifier, firstName, lastName, id);
    }
}
