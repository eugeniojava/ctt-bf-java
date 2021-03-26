package com.eugeniojava.covid19vaccination.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "report_table")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "report_date")
    private LocalDate date;

    @Column(name = "report_total")
    private Integer total;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "vaccine_id")
    private Vaccine vaccine;
}
