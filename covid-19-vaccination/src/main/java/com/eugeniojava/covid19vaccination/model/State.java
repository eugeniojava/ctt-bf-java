package com.eugeniojava.covid19vaccination.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "state_table")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private Long id;

    @NotBlank
    @Column(name = "state_name")
    private String name;

    @NotBlank
    @Size(min = 2, max = 2)
    @Column(name = "state_abbreviation", length = 2)
    private String abbreviation;

    @OneToMany(mappedBy = "state")
    @Column(name = "cities")
    private List<City> cities;
}
