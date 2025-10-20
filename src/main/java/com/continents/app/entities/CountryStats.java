package com.continents.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "country_stats")
public class CountryStats {

    @EmbeddedId
    private CountryStatsId id;

    @Column(name = "population")
    private Long population;
    @Column(name = "gdp")
    private BigDecimal gdp;

    @ManyToOne
    @MapsId("countryId")
    @JoinColumn(name="country_id")
    @JsonIgnore
    private Country country;

    public CountryStatsId getId() {
        return id;
    }

    public void setId(CountryStatsId id) {
        this.id = id;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
