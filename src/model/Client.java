package model;

public class Client extends Person{

    //Attributes
    private String address;
    private String tel;
    private String observations;

    //Methods
    public Client(String firstName, String lastName, String id, String address, String tel, String observations) {
        super(firstName, lastName, id);
        this.address = address;
        this.tel = tel;
        this.observations = observations;
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
