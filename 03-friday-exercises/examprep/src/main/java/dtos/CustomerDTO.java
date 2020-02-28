package dtos;

import entities.Customer;
import entities.Order;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carol
 */
public class CustomerDTO {

    private String name;
    private String email;
    private List<Order> orders = new ArrayList<>();

    public CustomerDTO(Customer customer) {
        this.name = customer.getEmail();
        this.email = customer.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
