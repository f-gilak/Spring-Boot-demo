package com.fariba.springBootDemo.rest;

import com.fariba.springBootDemo.entity.Customer;
import com.fariba.springBootDemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer findById(@PathVariable long id) {
        return customerService.findById(id);
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        customerService.save(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer update(@RequestBody Customer customer) {
        customerService.save(customer);
        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public String deleteById(@PathVariable long id) {
        return customerService.deleteById(id);
    }
}
