package model;

import java.util.ArrayList;

public class Product {
    //Attributes
    private String name;
    private FoodType type;
    private ArrayList<Ingredients> ingredients;
    private ArrayList<String> size;
    private ArrayList<Double> price;
    private boolean status;

    //Methods
    public Product(String name, FoodType type, ArrayList<Ingredients> ingredients, ArrayList<String> size, ArrayList<Double> price) {
        this.name = name;
        this.type = type;
        this.ingredients = ingredients;
        this.size = size;
        this.price = price;
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

    public ArrayList<String> getSize() {
        return size;
    }

    public void setSize(ArrayList<String> size) {
        this.size = size;
    }

    public ArrayList<Double> getPrice() {
        return price;
    }

    public void setPrice(ArrayList<Double> price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
