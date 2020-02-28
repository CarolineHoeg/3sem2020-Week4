package dtos;

import entities.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carol
 */
public class CustomersDTO {
    
    private List<CustomerDTO> customers = new ArrayList();

    public CustomersDTO(List<Customer> customerEntities) {
        for (Customer customer : customerEntities) {
            customers.add(new CustomerDTO(customer));
        }
    }
    
}
