package com.eugeniojava.covid19vaccination.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "vaccine_table")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_id")
    private Long id;

    @NotBlank
    @Column(name = "vaccine_name")
    private String name;

    @NotBlank
    @Column(name = "vaccine_origin")
    private String origin;
}
