package com.teste.haexagonal.adapters.inbound;

import com.teste.haexagonal.application.entity.Customer;
import com.teste.haexagonal.application.port.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/listAllCustomer")
    public ResponseEntity<List<Customer>> listAllCustomer() {
        return ResponseEntity.ok().body(customerService.listAllCustomer());
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<Void> DeleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/insertCustomer")
    public ResponseEntity<Customer> insertCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.created(URI.create("/insertCustomer")).body(customerService.insertCustomer(customerDto));
    }

    @PutMapping("updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok().body(this.customerService.updateCustomer(customerDto));
    }
}
