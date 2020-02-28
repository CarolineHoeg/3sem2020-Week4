package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author carol
 */
public class Tester {
    
    public static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("pu");

    public static void main(String[] args) {
        EntityManager em = EMF.createEntityManager();
        
        em.getTransaction().begin();
        Customer c1 = new Customer("John", "Doe");
        Customer c2 = new Customer("Jane", "Doe");
        em.persist(c1);
        em.persist(c2);
        //Noget med levetid gør at det følgende også bliver persisteret
        c1.addHobby("Knitting");
        c1.addHobby("Embroidery");
        c2.addHobby("Running");
        
        c1.addPhone("45454737", "Work phone");
        c1.addPhone("35870922", "Home phone");
        c2.addPhone("36879900", "Home phone");
        em.getTransaction().commit();
    }
}
