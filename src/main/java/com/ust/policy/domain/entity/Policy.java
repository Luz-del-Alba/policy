package com.ust.policy.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "policy")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "policy_sequence")
    @SequenceGenerator(name = "policy_sequence", sequenceName = "policy_sequence")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String number;

    private LocalDateTime createdAt;

    private LocalDateTime expires_in;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    public Customer customer;
}
