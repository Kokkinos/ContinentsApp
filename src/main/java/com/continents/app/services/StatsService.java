package com.continents.app.services;

import com.continents.app.dto.CountryStatsDTO;
import com.continents.app.dto.RegionContinentStatsDTO;
import com.continents.app.entities.CountryStats;
import com.continents.app.repositories.CountryStatsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatsService {

    @Autowired
    private CountryStatsRepo countryStatsRepo;

    public PagedModel<CountryStatsDTO> statsBetweenYears(Integer from, Integer to, Pageable pageable) {
        Page<CountryStats> page = countryStatsRepo.findByYearBetween(from, to, pageable);
        List<CountryStatsDTO> dtos = page.getContent().stream()
                .map(s -> new CountryStatsDTO(
                        s.getCountry().getName(),
                        s.getCountry().getCountryCode3(),
                        s.getId().getYear(),
                        s.getPopulation(),
                        s.getGdp() == null ? BigDecimal.ZERO : s.getGdp()
                ))
                .toList();
        Page<CountryStatsDTO> dtoPage = new PageImpl<>(dtos, page.getPageable(), page.getTotalElements());
        return new PagedModel<>(dtoPage);
    }

    public List<CountryStatsDTO> maxGdpPerCapitaForAllCountries() {
        List<Object[]> rows = countryStatsRepo.findMaxGdpPerCapitaRowsNative();
        return rows.stream().map(r -> {
            String countryName = r[1] == null ? null : r[1].toString();
            String countryCode3 = r[2] == null ? null : r[2].toString();
            Integer year = r[3] == null ? null : ((Number) r[3]).intValue();
            Long population = r[4] == null ? null : ((Number) r[4]).longValue();
            BigDecimal gdp = r[5] == null ? null : new BigDecimal(r[5].toString());
            return new CountryStatsDTO(countryName, countryCode3, year, population, gdp);
        }).collect(Collectors.toList());
    }

    public List<RegionContinentStatsDTO> filterByRegionAndYears(String regionName, Integer from, Integer to, int page, int size) {
        int offset = page * size;
        List<Object[]> rows = countryStatsRepo.findByRegionAndYearRangeNative(regionName, from, to, size, offset);
        return rows.stream().map(r -> {
            String continentName = r[0] == null ? null : r[0].toString();
            String regionNameVal = r[1] == null ? null : r[1].toString();
            String countryName = r[2] == null ? null : r[2].toString();
            Integer year = r[3] == null ? null : ((Number) r[3]).intValue();
            Long population = r[4] == null ? null : ((Number) r[4]).longValue();
            BigDecimal gdp = r[5] == null ? null : new BigDecimal(r[5].toString());
            return new RegionContinentStatsDTO(continentName, regionNameVal, countryName, year, population, gdp);
        }).collect(Collectors.toList());
    }
}
