package model;

import java.util.ArrayList;
import java.util.Date;

public class Order extends RestaurantObject{

    //Attributes
    private String code;
    private ArrayList<Integer> quantity;
    private ArrayList<Product> products;
    private Date time;
    private String observations;
    private Status status;
    private Employee deliverer;
    private Client client;

    //Methods
    public Order(User creator, User modifier, String code, ArrayList<Integer> quantity, ArrayList<Product> products, Date time, String observations, Employee deliverer, Client client) {
        super(creator, modifier);
        this.code = code;
        this.quantity = quantity;
        this.products = products;
        this.time = time;
        this.observations = observations;
        this.status = Status.SOLICITED;
        this.deliverer = deliverer;
        this.client = client;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<Integer> quantity) {
        this.quantity = quantity;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Employee getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(Employee deliverer) {
        this.deliverer = deliverer;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
