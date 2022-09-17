package com.fariba.springBootDemo.controller;

import com.fariba.springBootDemo.entity.Customer;
import com.fariba.springBootDemo.service.CustomerOldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerOldService customerService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "/customers/list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "/customers/customer-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") long id,Model model) {

        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "/customers/customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") long id,Model model) {

        String customer = customerService.deleteById(id);
//        model.addAttribute("customer", customer);
        return "redirect:/customers/list";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customers/list";
    }
}
