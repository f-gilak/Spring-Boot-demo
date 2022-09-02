package com.fariba.springBootDemo.rest;

import com.fariba.springBootDemo.entity.Customer;
import com.fariba.springBootDemo.service.CustomerOldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiOld")
public class CustomerOldRestController {

    @Autowired
    private CustomerOldService customerService;

    @GetMapping("/customersold")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/customersold/{id}")
    public Customer findById(@PathVariable long id) {
        return customerService.findById(id);
    }

    @PostMapping("/customersold")
    public Customer addCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        customerService.save(customer);
        return customer;
    }

    @PutMapping("/customersold")
    public Customer update(@RequestBody Customer customer) {
        customerService.save(customer);
        return customer;
    }

    @DeleteMapping("/customersold/{id}")
    public String deleteById(@PathVariable long id) {
        return customerService.deleteById(id);
    }
}
