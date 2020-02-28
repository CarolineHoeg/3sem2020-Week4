package facade;

import dtos.CustomerDTO;
import dtos.CustomersDTO;
import dtos.ItemTypeDTO;
import dtos.OrderDTO;
import entities.Customer;
import entities.ItemType;
import entities.Order;
import entities.OrderLine;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author carol
 */
public class CustomerFacade {

    private static CustomerFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private CustomerFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CustomerFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CustomerDTO addCustomer(String name, String email) {
        EntityManager em = getEntityManager();
        Customer cust = new Customer(name, email);
        em.getTransaction().begin();
        em.persist(cust);
        em.getTransaction().commit();
        return new CustomerDTO(cust);
    }

    public CustomerDTO getCustomer(int id) {
        EntityManager em = getEntityManager();
        Customer cust = getCustomer(em, id);
        return new CustomerDTO(cust);
    }
    
    private Customer getCustomer(EntityManager em, int id) {
        em.getTransaction().begin();
        Customer cust = em.find(Customer.class, id);
        em.getTransaction().commit();
        return cust;
    }

    public CustomersDTO getAllCustomers() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Customer> q = em.createNamedQuery("Customer.getAll", Customer.class);
            return new CustomersDTO(q.getResultList());
        } finally {
            em.close();
        }
    }
    
    public ItemTypeDTO addItemType(String name, String description, double price) {
        EntityManager em = getEntityManager();
        ItemType item = new ItemType(name, description, price);
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        return new ItemTypeDTO(item);
    }
    
    public ItemTypeDTO getItemType(int id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        ItemType item = em.find(ItemType.class, id);
        em.getTransaction().commit();
        return new ItemTypeDTO(item);
    }
    
    public OrderDTO createOrder(int customerId) {
        EntityManager em = getEntityManager();
        Customer cust = getCustomer(em, customerId);
        Order order = new Order(cust);
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        return new OrderDTO(order);
    }
    
    public OrderDTO createOrderLine(int quantity, ItemTypeDTO itemDTO, 
            int customerId) {
        EntityManager em = getEntityManager();
        ItemType item = new ItemType(itemDTO.getName(), itemDTO.getDescription(),
                itemDTO.getPrice());
        OrderLine orderLine = new OrderLine(quantity, item);
        Customer cust = getCustomer(em, customerId);
        Order order = new Order(cust);
        order.addOrderLine(orderLine);
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        return new OrderDTO(order);
    }
}
