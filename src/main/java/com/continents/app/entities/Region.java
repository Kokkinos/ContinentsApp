package com.continents.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "regions")
public class Region {

    @Id
    @Column(name = "region_id")
    private Integer id;
    @Column(name="name")
    private String name;

    /**
     * The Region entity is the owning side of the relationship with Continent
     * This entity has a foreign key column named continent_id referring to the primary id of Continent
     */
    @ManyToOne
    @JoinColumn(name="continent_id")
    private Continent continent;

    @OneToMany(mappedBy = "region")
    @JsonIgnore
    private List<Country> countries;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}

