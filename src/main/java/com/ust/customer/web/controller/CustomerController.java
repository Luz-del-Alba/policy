package com.ust.customer.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/customer")
public class CustomerController {

    @GetMapping
    public Map getAll() {
        return new HashMap();
    }

}
