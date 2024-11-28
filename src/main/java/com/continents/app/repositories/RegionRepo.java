package com.continents.app.repositories;

import com.continents.app.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepo extends JpaRepository<Region, Integer> {

//    List<Region> findByContinent_ContinentId(Long continentId);

}
