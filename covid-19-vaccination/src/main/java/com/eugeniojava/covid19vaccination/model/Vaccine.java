package com.eugeniojava.covid19vaccination.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @JsonManagedReference
    @OneToMany(mappedBy = "vaccine")
    private List<Report> reports;
}
