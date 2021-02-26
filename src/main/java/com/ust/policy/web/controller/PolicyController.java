package com.ust.policy.web.controller;

import com.ust.policy.domain.entity.Policy;
import com.ust.policy.service.PolicyService;
import com.ust.policy.web.model.CreatePolicyModel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/policy")
public class PolicyController {

    private final PolicyService policyService;

    @PostMapping
    public Policy save(@RequestBody CreatePolicyModel instance) {
        return this.policyService.createPolicy(instance);
    }

}
