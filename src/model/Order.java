package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends RestaurantObject{

    //Attributes
    private String code;
    private ArrayList<OrderMenuItem> items;
    private Date time;
    private String observations;
    private Status status;
    private Employee deliverer;
    private Client client;
    private String tPrice;

    //Methods
    public Order(User creator, User modifier, String code, List<OrderMenuItem> items, Date time, String observations, Employee deliverer, Client client) {
        super(creator, modifier);
        this.code = code;
        this.items = new ArrayList<>(items);
        this.time = time;
        this.observations = observations;
        this.status = Status.SOLICITED;
        this.deliverer = deliverer;
        this.client = client;
        Double price = 0.0;
        for(int i = 0; i < items.size(); i++){
            price += Double.valueOf(items.get(i).getPriceT());
        }
        this.tPrice = price.toString();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public List<OrderMenuItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderMenuItem> items) {
        this.items = items;
    }

    public String gettPrice() {
        return tPrice;
    }

    public void settPrice(String tPrice) {
        this.tPrice = tPrice;
    }
}
