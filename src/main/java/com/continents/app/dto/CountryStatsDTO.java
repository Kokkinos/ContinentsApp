package com.continents.app.dto;

import java.math.BigDecimal;

public class CountryStatsDTO {

    private String countryName;
    private String countryCode3;
    private Integer year;
    private Long population;
    private BigDecimal gdp;

    public CountryStatsDTO() {}

    public CountryStatsDTO(String countryName, String countryCode3,
                           Integer year, Long population, BigDecimal gdp) {
        this.countryName = countryName;
        this.countryCode3 = countryCode3;
        this.year = year;
        this.population = population;
        this.gdp = gdp;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode3() {
        return countryCode3;
    }

    public void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public BigDecimal getGdp() {
        return gdp;
    }

    public void setGdp(BigDecimal gdp) {
        this.gdp = gdp;
    }
}
