package com.ust.policy.domain.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
@Builder(toBuilder = true)
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
    @SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    public String names;

    @Column(name = "email")
    public String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password")
    public String password;

    @OneToMany(mappedBy = "customer")
    public List<Policy> policies = new ArrayList<Policy>();

}
