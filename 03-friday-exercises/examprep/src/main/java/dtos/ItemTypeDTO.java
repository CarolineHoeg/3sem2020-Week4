package dtos;

import entities.ItemType;
import entities.OrderLine;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carol
 */
public class ItemTypeDTO {
    private String name;
    private String description;
    private double price;
    private List<OrderLine> orderlines = new ArrayList<>();

    public ItemTypeDTO(ItemType item) {
        this.name = item.getName();
        this.description = item.getDescription();
        this.price = item.getPrice();
        orderlines = item.getOrderlines();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<OrderLine> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(List<OrderLine> orderlines) {
        this.orderlines = orderlines;
    }
    
    
}
