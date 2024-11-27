package com.qualco.assignment.repositories;

import com.qualco.assignment.entities.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContinentRepo extends JpaRepository<Continent, Integer> {

//    Optional<Continent> findByName(String name);
}
