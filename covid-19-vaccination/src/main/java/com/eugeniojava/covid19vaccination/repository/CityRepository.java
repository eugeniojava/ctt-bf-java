package com.eugeniojava.covid19vaccination.repository;

import com.eugeniojava.covid19vaccination.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findByNameAndStateName(String name, String state);
}
