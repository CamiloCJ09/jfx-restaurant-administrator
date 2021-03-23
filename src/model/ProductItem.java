package model;

import java.util.ArrayList;
import java.util.List;

public class ProductItem extends RestaurantObject{

    private String name;
    private String foodType;
    private List<Ingredients> ingredients;
    private String size;
    private String price;

    public ProductItem(User creator, User modifier, Product product, int index){
        super(creator, modifier);
        this.name = product.getName();
        this.foodType = product.getType().getName();
        this.ingredients = product.getIngredients();
        this.size = product.getSizes().get(index).getSize();
        this.price = String.valueOf(product.getSizes().get(index).getPrice());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }
}
