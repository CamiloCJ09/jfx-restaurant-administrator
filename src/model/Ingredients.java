package model;

public class Ingredients extends RestaurantObject{
    //Attributes
    private String name;

    //Methods
    public Ingredients(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
