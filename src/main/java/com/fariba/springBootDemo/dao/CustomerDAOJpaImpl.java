package com.fariba.springBootDemo.dao;

import com.fariba.springBootDemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerDAOJpaImpl implements CustomerDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        Query query = entityManager.createQuery("select c from Customer c order by id");
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public Customer findById(long id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void save(Customer customer) {
        Customer merge = entityManager.merge(customer);
        customer.setId(merge.getId());
    }

    @Override
    public void deleteById(long id) {
        Query query = entityManager.createQuery("delete from Customer c where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
