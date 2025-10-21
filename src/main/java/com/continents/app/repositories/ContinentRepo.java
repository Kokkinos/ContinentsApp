package com.continents.app.repositories;

import com.continents.app.entities.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepo extends JpaRepository<Continent, Integer> {


}
