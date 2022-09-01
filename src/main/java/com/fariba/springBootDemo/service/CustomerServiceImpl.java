package com.fariba.springBootDemo.service;

import com.fariba.springBootDemo.dao.CustomerDAO;
import com.fariba.springBootDemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    @Qualifier("customerDAOJpaImpl")
    private CustomerDAO customerDAO;

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public Customer findById(long id) {
        Customer customer = customerDAO.findById(id);
        if (customer == null) {
            throw new RuntimeException("Customer id not found - " + id);
        }
        return customer;
    }

    @Override
    public void save(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    public String deleteById(long id) {
        Customer customer = findById(id);
        customerDAO.deleteById(id);
        return "Customer id deleted - " + id;
    }
}
