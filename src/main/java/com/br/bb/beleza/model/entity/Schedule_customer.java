package com.br.bb.beleza.model.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table( name = "customer_schedule" , schema = "beleza_brasileira")
public class Schedule_customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_schedule")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @Column
    @CreatedDate
    private LocalDateTime createdDate;


}
