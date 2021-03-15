package model;

public class Ingredients extends RestaurantObject{
    //Attributes
    private String name;

    //Methods
    public Ingredients(User creator, User modifier, String name){
        super(creator, modifier);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
