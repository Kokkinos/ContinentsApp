package com.continents.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class CountryStatsId {

    private Integer countryId;
    private Integer year;

    public CountryStatsId() {}
    public CountryStatsId(Integer countryId, Integer year) {
        this.countryId = countryId;
        this.year = year;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryStatsId)) return false;
        CountryStatsId that = (CountryStatsId) o;
        return Objects.equals(countryId, that.countryId) && Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, year);
    }
}
