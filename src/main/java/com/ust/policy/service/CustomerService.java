package com.ust.policy.service;

import com.ust.policy.domain.entity.Customer;
import com.ust.policy.domain.repository.CustomerRepository;
import com.ust.policy.web.model.CreatePolicyModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer getOrSave(CreatePolicyModel instance) {
        log.info("Lookup for customer {}", instance.getEmail());
        val customerLookup = customerRepository.findByEmail(instance.getEmail());

        if (customerLookup.isPresent()) {
            log.info("Customer already present on the Platform {}", customerLookup.get());
            return customerLookup.get();
        }
        log.info("New customer about to be created {}", instance);

        val newCustomer = Customer.builder()
                .names(instance.getName())
                .email(instance.getEmail())
                .build();

        return this.customerRepository.save(newCustomer);
    }

    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }
}
