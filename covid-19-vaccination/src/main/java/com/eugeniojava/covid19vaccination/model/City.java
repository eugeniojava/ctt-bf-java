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
@Table(name = "city_table")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;

    @NotBlank
    @Column(name = "city_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;
}
