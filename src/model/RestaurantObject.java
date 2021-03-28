package model;

import java.io.Serializable;

public abstract class RestaurantObject implements Serializable {

    public final static long serialVersionUID = 1;

    private User creator;
    private User modifier;

    public RestaurantObject(User creator, User modifier){
        this.creator = creator;
        this.modifier = modifier;
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
}
