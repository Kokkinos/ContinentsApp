package com.continents.app.repositories;

import com.continents.app.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepo extends JpaRepository<Region, Integer> {

//    List<Region> findByContinent_ContinentId(Long continentId);
    List<Region> findByContinentId(Integer continentId);
}
