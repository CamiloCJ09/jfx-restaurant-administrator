package model;

public class FoodType extends RestaurantObject{

    public FoodType(User creatorUser, User modifierUser, String name){
        super(creatorUser, modifierUser);
        this.name = name;
    }

    //Attributes
    private String name;

    //Methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
