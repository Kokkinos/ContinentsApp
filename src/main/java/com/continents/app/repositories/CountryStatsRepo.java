package com.continents.app.repositories;

import com.continents.app.dto.CountryStatsDTO;
import com.continents.app.entities.CountryStats;
import com.continents.app.entities.CountryStatsId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryStatsRepo extends JpaRepository<CountryStats, CountryStatsId> {
//
//    @Query("SELECT new com.continents.app.dto.CountryStatsDTO(c.name, cs.id.countryId, cs.id.year, cs.population, cs.gdp, (cs.gdp / cs.population) as gdpPerPopulation) " +
//            "FROM CountryStats cs JOIN cs.country c " +
//            "WHERE (cs.gdp / cs.population) = (SELECT MAX(cs2.gdp / cs2.population) FROM CountryStats cs2 WHERE cs2.id.countryId = cs.id.countryId) " +
//            "ORDER BY c.name")
//    List<CountryStatsDTO> findMaxGdpPerPopulationForEachCountry();


    @Query("""
        SELECT cs FROM CountryStats cs
        WHERE cs.id.year BETWEEN :fromYear AND :toYear
        """)
    Page<CountryStats> findByYearBetween(Integer fromYear, Integer toYear, Pageable pageable);

    // Task #2: for each country, get stat row(s) with max (gdp/population) ratio
    // Use native query because of ratio and null/zero population handling
    @Query(value = """
        SELECT c.country_id as countryId, c.name as countryName, c.country_code3 as countryCode3,
               s.year as year, s.population as population, s.gdp as gdp
        FROM country_stats s
        JOIN countries c ON c.country_id = s.country_id
        JOIN (
           SELECT country_id, MAX(CASE WHEN population IS NULL OR population = 0 THEN 0 ELSE (gdp / population) END) AS max_ratio
           FROM country_stats
           GROUP BY country_id
        ) m ON m.country_id = s.country_id
        WHERE (CASE WHEN s.population IS NULL OR s.population = 0 THEN 0 ELSE (s.gdp / s.population) END) = m.max_ratio
        """, nativeQuery = true)
    List<Object[]> findMaxGdpPerCapitaRowsNative();

    @Query(value = """
        SELECT cont.name as continentName, r.name as regionName, c.name as countryName,
               s.year as year, s.population as population, s.gdp as gdp
        FROM country_stats s
        JOIN countries c ON c.country_id = s.country_id
        JOIN regions r ON r.region_id = c.region_id
        JOIN continents cont ON cont.continent_id = r.continent_id
        WHERE (:regionId IS NULL OR r.region_id = :regionId)
          AND s.year BETWEEN :fromYear AND :toYear
        ORDER BY cont.name, r.name, c.name, s.year
        LIMIT :limit OFFSET :offset
        """, nativeQuery = true)
    List<Object[]> findByRegionAndYearRangeNative(Integer regionId, Integer fromYear, Integer toYear, int limit, int offset);
}
