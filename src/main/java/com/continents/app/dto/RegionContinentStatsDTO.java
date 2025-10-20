package com.continents.app.dto;

import java.math.BigDecimal;

public class RegionContinentStatsDTO {

    private String continentName;
    private String regionName;
    private String countryName;
    private Integer year;
    private Long population;
    private BigDecimal gdp;

    public RegionContinentStatsDTO() {}

    public RegionContinentStatsDTO(String continentName, String regionName, String countryName,
                                   Integer year, Long population, BigDecimal gdp) {
        this.continentName = continentName;
        this.regionName = regionName;
        this.countryName = countryName;
        this.year = year;
        this.population = population;
        this.gdp = gdp;
    }

    // getters & setters
    public String getContinentName() { return continentName; }
    public String getRegionName() { return regionName; }
    public String getCountryName() { return countryName; }
    public Integer getYear() { return year; }
    public Long getPopulation() { return population; }
    public BigDecimal getGdp() { return gdp; }

    public void setContinentName(String continentName) { this.continentName = continentName; }
    public void setRegionName(String regionName) { this.regionName = regionName; }
    public void setCountryName(String countryName) { this.countryName = countryName; }
    public void setYear(Integer year) { this.year = year; }
    public void setPopulation(Long population) { this.population = population; }
    public void setGdp(BigDecimal gdp) { this.gdp = gdp; }
}
