package com.qualco.assignment.repositories;

import com.qualco.assignment.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepo extends JpaRepository<Region, Integer> {

//    List<Region> findByContinent_ContinentId(Long continentId);

}
