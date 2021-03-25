package model;

import java.util.Date;
import java.util.List;

public class ObservableOrder extends RestaurantObject{
    private String code;
    private List<OrderMenuItem> items;
    private String date;
    private String observations;
    private String status;
    private String employee;
    private String client;
    private String priceT;

    public ObservableOrder(User creator, User modifier, String code, List<OrderMenuItem> items, Date date, String observations, Status status, Employee employee, Client client, String tPrice){
        super(creator, modifier);
        this.code = code;
        this.items = items;
        this.date = date.toString();
        this.observations = observations;
        this.status = status.toString();
        this.employee = employee.getFirstName() + " " + employee.getLastName();
        this.client = client.getFirstName() + " " + client.getLastName();
        this.priceT = tPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<OrderMenuItem> getItems() {
        return items;
    }

    public void setItems(List<OrderMenuItem> items) {
        this.items = items;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getPriceT() {
        return priceT;
    }

    public void setPriceT(String priceT) {
        this.priceT = priceT;
    }
}
