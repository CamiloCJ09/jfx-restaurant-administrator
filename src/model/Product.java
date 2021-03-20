package model;

import java.util.ArrayList;
import java.util.List;

public class Product extends RestaurantObject{
    //Attributes
    private String name;
    private FoodType type;
    private List<Ingredients> ingredients;
    private List<Size> sizes;
    private boolean status;

    //Methods
    public Product(User creator, User modifier, String name, FoodType type, List<Ingredients> ingredients, List<Size> size) {
        super(creator, modifier);
        this.name = name;
        this.type = type;
        this.ingredients = ingredients;
        this.sizes = size;
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

    public void setIngredients(ArrayList<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
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
