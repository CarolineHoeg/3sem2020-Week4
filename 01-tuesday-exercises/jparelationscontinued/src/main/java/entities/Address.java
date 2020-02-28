package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author carol
 */
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
//    @OneToOne(mappedBy = "address")
//    private Customer customer;
//    @ManyToOne
//    private Customer customer;
    @ManyToMany(mappedBy = "addresses")
    private List<Customer> customers;
    
    public Address() {
    }

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

//    public Address(String street, String city, Customer customer) {
//        this.street = street;
//        this.city = city;
//        this.customer = customer;
//    }

    public Address(String street, String city, List<Customer> customers) {
        this.street = street;
        this.city = city;
        this.customers = customers;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
}
