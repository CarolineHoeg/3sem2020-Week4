package facades;

import entities.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
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

    public Customer getCustomer(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Customer.class, id);
        } finally {
            em.close();
        }
    }

    public List<Customer> getCustomers() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Customer> q = em.createQuery("SELECT c FROM Customer c",
                    Customer.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Customer addCustomer(Customer cust) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cust);
        em.getTransaction().commit();
        return cust;
    }

    public Customer deleteCustomer(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Customer cust = em.find(Customer.class, id);
//            Query q = em.createQuery("DELETE FROM Customer c WHERE c.id = :id");
//            q.setParameter("id", id);
            em.remove(cust);
            em.getTransaction().commit();
            return cust;
        } finally {
            em.close();
        }
    }

    public Customer editCustomer(Customer cust) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
//            Customer find = em.find(Customer.class, cust.getId());
//            find.setFirstName(cust.getFirstName());
//            find.setLastName(cust.getLastName());
            em.merge(cust);
            em.getTransaction().commit();
            return cust;
        } finally {
            em.close();
        }
    }

}
