package model;

import java.util.Date;

public class EmployeeOrders extends RestaurantObject{

    private Date date;
    private double orderPrice;

    public EmployeeOrders(User creator, User modifier, Date date, double orderPrice){
        super(creator, modifier);
        this.date = date;
        this.orderPrice = orderPrice;
    }
}
