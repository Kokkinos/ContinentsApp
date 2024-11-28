package com.continents.app.repositories;

import com.continents.app.entities.CountryStats;
import com.continents.app.entities.CountryStatsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryStatsRepo extends JpaRepository<CountryStats, CountryStatsId> {

//    Optional<CountryStats> findById_CountryIdAndId_Year(Long countryId, Integer year);
//
//    List<CountryStats> findByCountry_CountryId(Long countryId);
}
