package model;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Product extends RestaurantObject{
    //Attributes
    private String name;
    private FoodType type;
    private ArrayList<Ingredients> ingredients;
    private ArrayList<Size> sizes;
    private boolean status;

    //Methods
    public Product(User creator, User modifier, String name, FoodType type, ObservableList<Ingredients> ingredients, ObservableList<Size> size) {
        super(creator, modifier);
        this.name = name;
        this.type = type;
        this.ingredients = new ArrayList<>(ingredients);
        this.sizes = new ArrayList<>(size);
        this.status = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    public ArrayList<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<Size> getSizes() {
        return sizes;
    }

    public void setSizes(ArrayList<Size> sizes) {
        this.sizes = sizes;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Size findSize(String size){
        boolean found = false;
        Size rSize = null;
        for(int i = 0; i<sizes.size() && !found; i++){
            if(sizes.get(i).getSize().equals(size)){
                rSize = sizes.get(i);
                found = true;
            }
        }
        return rSize;
    }
}
