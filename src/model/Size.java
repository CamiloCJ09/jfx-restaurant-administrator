package model;

public class Size extends RestaurantObject{
    private String size;
    private double price;

    public Size(User creator, User modifier, String size, double price){
        super(creator, modifier);
        this.size = size;
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
