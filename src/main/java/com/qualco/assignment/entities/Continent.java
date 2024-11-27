package com.qualco.assignment.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="continents")
public class Continent {

    @Id
    @Column(name="continent_id")
    private Integer id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "continent")
    @JsonIgnore
    private List<Region> regions;

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

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
