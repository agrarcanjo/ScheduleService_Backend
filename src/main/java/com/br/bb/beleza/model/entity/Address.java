package com.br.bb.beleza.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "address" , schema = "beleza_brasileira")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "place")
    private String place;

    @Column(name = "complement")
    private String complement;

    @Column(name = "number")
    private String number;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "cep")
    private String cep;

    @Column(name = "typeAddress")
    private Integer typeAddress;

    @Column(name = "city")
    private Long city;

    @OneToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;
}
