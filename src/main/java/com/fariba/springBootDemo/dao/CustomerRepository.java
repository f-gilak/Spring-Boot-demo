package com.fariba.springBootDemo.dao;

import com.fariba.springBootDemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "people")
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    public List<Customer> findAllByOrderByLastNameDesc();
}
