package com.fariba.springBootDemo.dao;

import com.fariba.springBootDemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "people")
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
