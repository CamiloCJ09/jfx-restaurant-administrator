package model;

import java.io.Serializable;

public abstract class RestaurantObject implements Serializable {

    public final static long serialVersionUID = 1;

    private User creator;
    private User modifier;
    private int references;
    boolean status;

    public RestaurantObject(User creator, User modifier){
        this.creator = creator;
        this.modifier = modifier;
        this.references = 0;
        this.status = true;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getModifier() {
        return modifier;
    }

    public void setModifier(User modifier) {
        this.modifier = modifier;
    }

    public int getReferences() {
        return references;
    }

    public void setReferences(int references) {
        this.references = references;
    }

    public boolean isStatus() {
        return status;
    }

    public String getStatus() {
        String text = "";
        if(this.status){
            text = "HABILITADO";
        } else{
            text = "DESHABILITADO";
        }
        return text;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void changeStatus(){
        if(this.status){
            this.status = false;
        } else{
            this.status = true;
        }
    }
}
