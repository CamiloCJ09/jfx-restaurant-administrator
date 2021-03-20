package model;

public class OrderMenuItem extends RestaurantObject{

    private String productName;
    private String size;
    private String amount;
    private String uPrice;
    private String tPrice;

    public OrderMenuItem(User creator, User modifier, Product product, Size size, double amount){
        super(creator, modifier);
        this.productName = product.getName();
        this.size = size.getSize();
        this.amount = String.valueOf(amount);
        this.uPrice = String.valueOf(size.getPrice());
        this.tPrice = String.valueOf(size.getPrice()*amount);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getuPrice() {
        return uPrice;
    }

    public void setuPrice(String uPrice) {
        this.uPrice = uPrice;
    }

    public String gettPrice() {
        return tPrice;
    }

    public void settPrice(String tPrice) {
        this.tPrice = tPrice;
    }
}
