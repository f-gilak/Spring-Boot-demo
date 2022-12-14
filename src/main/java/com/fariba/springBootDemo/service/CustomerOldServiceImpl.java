package com.fariba.springBootDemo.service;

import com.fariba.springBootDemo.dao.CustomerRepository;
import com.fariba.springBootDemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerOldServiceImpl implements CustomerOldService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAllByOrderByLastNameDesc();
    }

    @Override
    public Customer findById(long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        }
        throw new RuntimeException("Customer id not found - " + id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public String deleteById(long id) {
        Customer customer = findById(id);
        customerRepository.deleteById(id);
        return "Customer id deleted - " + id;
    }
}
