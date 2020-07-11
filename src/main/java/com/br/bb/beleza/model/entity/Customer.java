package com.br.bb.beleza.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "customer" , schema = "beleza_brasileira")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "typePerson")
    private Integer typePerson;

    @ManyToMany
    @JoinTable(name = "customer_schedule",
            joinColumns = @JoinColumn(name = "id_customer"),
            inverseJoinColumns = @JoinColumn(name = "id_schedule"))
    private List<Schedule> schedules;

    @OneToOne(mappedBy = "customer")
    private Address address;

    @OneToOne
    @JoinColumn(name = "id_person")
    private Person person;
}
