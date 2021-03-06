package model;

import java.io.Serializable;

public class Client extends Person implements Comparable<Client>{

    //Attributes
    private String address;
    private String tel;
    private String observations;

    //Methods
    public Client(User creator, User modifier, String firstName, String lastName, String id, String address, String tel, String observations) {
        super(creator, modifier, firstName, lastName, id);
        this.address = address;
        this.tel = tel;
        this.observations = observations;
    }

    @Override
    public int compareTo(Client otherClient) {
        return this.getLastName().compareToIgnoreCase(otherClient.getLastName());
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
