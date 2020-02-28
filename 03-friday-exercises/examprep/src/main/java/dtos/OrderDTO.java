package dtos;

import entities.Customer;
import entities.Order;
import entities.OrderLine;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carol
 */
public class OrderDTO {
    private int orderId;
    private Customer customer;
    private List<OrderLine> orderLines = new ArrayList<>();

    public OrderDTO(Order order) {
        this.orderId = order.getOrderId();
        this.customer = order.getCustomer();
        this.orderLines = order.getOrderLines();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
    
}
