package com.eugeniojava.covid19vaccination.repository;

import com.eugeniojava.covid19vaccination.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
}
