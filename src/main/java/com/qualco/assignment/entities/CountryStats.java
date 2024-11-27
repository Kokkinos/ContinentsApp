package com.qualco.assignment.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "country_stats")
public class CountryStats {

    @EmbeddedId
    private CountryStatsId id;

    @Column(name = "population")
    private Long population;
    @Column(name = "gdp")
    private Double gdp;

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

    public Double getGdp() {
        return gdp;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
