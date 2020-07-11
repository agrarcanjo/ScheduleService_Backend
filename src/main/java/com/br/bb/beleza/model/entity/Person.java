package com.br.bb.beleza.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "person" , schema = "beleza_brasileira")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private Character genre;

    @Column(name = "email")
    private String email;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "phone")
    private String phone;

    @Column(name = "cellphone")
    private String cellphone;

    @LastModifiedDate
    private Date lastModifiedDate;

    @JsonIgnore
    @Column(name = "pass")
    private String pass;

    @CreatedDate
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate createdDate;

    @Column(name = "last_modification_person")
    private String lastModificationPerson;


}
