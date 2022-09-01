package com.fariba.springBootDemo.service;

import com.fariba.springBootDemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();

    public Customer findById(long id);

    public void save(Customer customer);

    public String deleteById(long id);
}
