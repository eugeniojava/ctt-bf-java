package com.eugeniojava.covid19vaccination.repository;

import com.eugeniojava.covid19vaccination.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    Optional<State> findByAbbreviation(String abbreviation);
}
