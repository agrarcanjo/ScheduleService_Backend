package com.br.bb.beleza.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.profile.Fetch;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "schedule" , schema = "beleza_brasileira")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_schedule")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate dtSchedule;

    @Column(name = "note")
    private String note;

    @Column(name = "situation")
    private Integer situation;

    @ManyToMany(mappedBy = "schedules")
    private List<Customer> customers;

    @ManyToOne
    @JoinColumn(name = "id_profession_person")
    private Person professionPerson;

    @OneToOne
    @JoinColumn(name = "id_service")
    private Service service;

}
