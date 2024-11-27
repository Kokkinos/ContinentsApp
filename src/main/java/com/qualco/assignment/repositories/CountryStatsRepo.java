package com.qualco.assignment.repositories;

import com.qualco.assignment.entities.CountryStats;
import com.qualco.assignment.entities.CountryStatsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryStatsRepo extends JpaRepository<CountryStats, CountryStatsId> {

//    Optional<CountryStats> findById_CountryIdAndId_Year(Long countryId, Integer year);
//
//    List<CountryStats> findByCountry_CountryId(Long countryId);
}
