import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        saveCustomer();
        //getAllCustomers();
        //getCustomer(1);
        //deleteCustomerById(1);
        //deleteCustomerByObject(2);
        //updateCustomer();
    }
    private static void updateCustomer(){
        Customer c1 = new Customer(2,"Isuranga","Galle",25000);

        /*Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();*/
        Session session = HibernateUtil.openSession();

        Transaction transaction = session.beginTransaction();

        session.update(c1);
        transaction.commit();
        session.close();
        //sessionFactory.close();
    }


    private static void deleteCustomerById(long id){
        /*Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();*/
        Session session = HibernateUtil.openSession();

        Query query = session.createQuery("DELETE Customer WHERE Customer_id=:id");
        query.setParameter("id",id);
        query.executeUpdate();
        //transaction.commit();
    }

    private static void deleteCustomerByObject(long id){
        /*Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();*/
        Session session = HibernateUtil.openSession();

        session.delete(session.get(Customer.class,id));
        //transaction.commit();
    }

    private static void getCustomer(long id){
        /*Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();*/
        Session session = HibernateUtil.openSession();

        Customer customer = session.get(Customer.class, id);
        System.out.println(customer);
    }

    private static void getAllCustomers(){
        /*Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();*/
        Session session = HibernateUtil.openSession();

        Query query = session.createQuery("FROM Customer");
        List list = query.list();
        System.out.println(list);
    }

    private static void saveCustomer() {
        Customer c1 = new Customer(5,"Imesh","Galle",25000);

        /*Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();*/
        Session session = HibernateUtil.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(c1);
        transaction.commit();
        session.close();
       // sessionFactory.close();
    }
}
