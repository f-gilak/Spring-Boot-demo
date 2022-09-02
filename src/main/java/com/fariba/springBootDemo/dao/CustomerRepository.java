package com.fariba.springBootDemo.dao;

import com.fariba.springBootDemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
