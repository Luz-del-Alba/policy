package com.ust.policy.web.controller;

import com.ust.policy.domain.entity.Customer;
import com.ust.policy.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/customer")
public class CustomerContoller {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAll() {
        return this.customerService.getAll();
    }
}
