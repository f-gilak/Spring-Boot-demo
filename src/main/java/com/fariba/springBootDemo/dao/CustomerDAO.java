package com.fariba.springBootDemo.dao;


import com.fariba.springBootDemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> findAll();

    public Customer findById(long id);

    public void save(Customer customer);

    public void deleteById(long id);
}
