package com.continents.app.repositories;

import com.continents.app.dto.CountryDTO;
import com.continents.app.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {

//    List<Country> findByNameContainingIgnoreCase(String name);
//    List<Country> findByRegion_RegionId(Long regionId);
    @Query("SELECT new com.continents.app.dto.CountryDTO(c.id, c.name,c.area,c.countryCode2)" +
            "FROM Country c ORDER BY c.name ASC")
    List<CountryDTO> findAllCountriesOrderderByName();
}
