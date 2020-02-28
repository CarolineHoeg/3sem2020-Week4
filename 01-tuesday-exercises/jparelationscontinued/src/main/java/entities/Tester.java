package entities;

import facades.CustomerFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author carol
 */
public class Tester {

    public static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("pu");

//    public static void main(String[] args) {
//        Persistence.generateSchema("pu", null);
//    }
    
//    public static void main(String[] args) {
//        EntityManager em = EMF.createEntityManager();
//
//        em.getTransaction().begin();
//        Customer c1 = new Customer("John", "Doe");
//        Customer c2 = new Customer("Jane", "Doe");
//    
//        List<Address> addresses = new ArrayList<>();
//        addresses.add(new Address("Vestergade 25", "Copenhagen"));
//        addresses.add(new Address("Østergade 53b", "Copenhagen"));
//        c2.setAddresses(addresses);
//        
//        em.persist(addresses.get(0));
//        em.persist(addresses.get(1));
//        
//        em.persist(c1);
//        em.persist(c2);
//        
//        em.getTransaction().commit();
//    }
    
//    public static void main(String[] args) {
//        EntityManager em = EMF.createEntityManager();
//
//        em.getTransaction().begin();
//        Customer c1 = new Customer("John", "Doe");
//        Customer c2 = new Customer("Jane", "Doe");
//
//        em.persist(c1);
//        em.persist(c2);
//
//        Address a1 = new Address("Vestergade 25", "Copenhagen", c2);
//        Address a2 = new Address("Østergade 53b", "Copenhagen", c2);
//        Address a3 = new Address("Østergade 53f", "Copenhagen", c1);
//        
//        em.persist(a1);
//        em.persist(a2);
//        em.persist(a3);
//        
//        c2.addAddress(a1);
//        c2.addAddress(a2);
//        c1.addAddress(a3);
//
//        em.getTransaction().commit();
//    }
    
    public static void main(String[] args) {
        EntityManager em = EMF.createEntityManager();

        em.getTransaction().begin();
        List<Customer> customers = new ArrayList<>();
        Customer c1 = new Customer("John", "Doe");
        Customer c2 = new Customer("Jane", "Doe");
        Customer c3 = new Customer("Joseph", "Doe");

        em.persist(c1);
        em.persist(c2);
        em.persist(c3);

        Address a1 = new Address("Vestergade 25", "Copenhagen", customers);
        Address a2 = new Address("Østergade 53b", "Copenhagen", customers);
        Address a3 = new Address("Østergade 53f", "Copenhagen");
        
        em.persist(a1);
        em.persist(a2);
        em.persist(a3);
        
        c1.addAddress(a1);
        c1.addAddress(a2);
        c2.addAddress(a1);
        c2.addAddress(a2);
        c3.addAddress(a3);
        
        em.getTransaction().commit();
        
        CustomerFacade facade = CustomerFacade.getFacade(EMF);
        facade.deleteCustomer(c1.getId());
        c2.setFirstName("Chuck");
        facade.editCustomer(c2);
    }

}
