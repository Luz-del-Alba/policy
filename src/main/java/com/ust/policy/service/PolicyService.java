package com.ust.policy.service;

import com.ust.policy.domain.entity.Policy;
import com.ust.policy.domain.repository.PolicyRepository;
import com.ust.policy.web.model.CreatePolicyModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class PolicyService {

    private final CustomerService customerService;

    private final PolicyRepository policyRepository;

    public Policy createPolicy(CreatePolicyModel instance) {
        val customer = customerService.getOrSave(instance);

        val newPolicy = Policy.builder()
                .number(UUID.randomUUID().toString())
                .customer(customer)
                .build();

        return policyRepository.save(newPolicy);
    }

}
