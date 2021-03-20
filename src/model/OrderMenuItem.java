package model;

public class OrderMenuItem extends RestaurantObject{

    private String productName;
    private String size;
    private String amount;
    private String priceU;
    private String priceT;

    public OrderMenuItem(User creator, User modifier, Product product, Size size, double amount){
        super(creator, modifier);
        this.productName = product.getName();
        this.size = size.getSize();
        this.amount = String.valueOf(amount);
        this.priceU = String.valueOf(size.getPrice());
        this.priceT = String.valueOf(size.getPrice()*amount);
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

    public String getPriceU() {
        return priceU;
    }

    public void setPriceU(String priceU) {
        this.priceU = priceU;
    }

    public String getPriceT() {
        return priceT;
    }

    public void setPriceT(String priceT) {
        this.priceT = priceT;
    }
}
