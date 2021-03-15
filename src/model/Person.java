package model;

public abstract class Person extends RestaurantObject{

    //Attributes
    private String firstName;
    private String lastName;
    private String id;

    //Methods
    public Person(User creator, User modifier, String firstName, String lastName, String id) {
        super(creator, modifier);
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
