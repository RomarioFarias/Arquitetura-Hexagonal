package com.teste.haexagonal.adapters.inbound;

import com.teste.haexagonal.application.entity.Customer;
import com.teste.haexagonal.application.port.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    private final CustomerMapper customerMapper;

    @GetMapping("/listAllCustomer")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> listAllCustomer() {

        var listCostumer = customerService.listAllCustomer();
        return this.customerMapper.toListCustomerDto(listCostumer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteCustomer(@PathVariable Long id) {

        this.customerService.deleteCustomer(id);
    }

    @PostMapping("/insertCustomer")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto insertCustomer(@RequestBody CustomerDto customerDto) {
        var customer = customerService.insertCustomer(this.customerMapper.toCustomer(customerDto));
        return customerMapper.toCustomerDto(customer);
    }

    @PutMapping("updateCustomer")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto updateCustomer(@RequestBody Customer customer) {
        var customerEntity = this.customerService.updateCustomer(customer);
        return this.customerMapper.toCustomerDto(customerEntity);
    }
}
