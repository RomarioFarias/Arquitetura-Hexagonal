package com.teste.haexagonal.adapters.outbound;

import com.teste.haexagonal.application.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataCustomerRepository extends JpaRepository<Customer, Long> {
}
