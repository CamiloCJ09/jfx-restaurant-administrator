package model;

import java.util.List;

public class Employee extends Person {

    List<EmployeeOrders> employeeOrders;

    public Employee(User creator, User modifier, String firstName, String lastName, String id){
        super(creator, modifier, firstName, lastName, id);
    }
}
