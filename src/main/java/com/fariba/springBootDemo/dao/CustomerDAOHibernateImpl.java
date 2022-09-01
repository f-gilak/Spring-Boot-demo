package com.fariba.springBootDemo.dao;

import com.fariba.springBootDemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDAOHibernateImpl implements CustomerDAO {

    private EntityManager entityManager;

    @Autowired
    public CustomerDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Customer> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Customer> customerQuery = currentSession.createQuery(
                "select c from Customer c order by c.lastName", Customer.class);
        List<Customer> customers = customerQuery.getResultList();
        return customers;
    }

    @Override
    public Customer findById(long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Customer customer = currentSession.get(Customer.class,id);
        return customer;
    }

    @Override
    public void save(Customer customer) {
        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(customer);
    }

    @Override
    public void deleteById(long id) {
        Session session=entityManager.unwrap(Session.class);
        Query query=session.createQuery("delete from Customer where id=:id");
        query.setParameter("id",id);
        query.executeUpdate();
    }
}