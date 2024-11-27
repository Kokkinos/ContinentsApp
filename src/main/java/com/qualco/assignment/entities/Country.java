package com.qualco.assignment.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="countries")
public class Country {

    @Id
    @Column(name="country_id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="area")
    private Double area;
    @Column(name="national_day")
    private Date nationalDay;
    @Column(name = "country_code2")
    private String countryCode2;
    @Column(name = "country_code3")
    private String countryCode3;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "country")
    private List<CountryStats> stats;

    @ManyToMany
    @JoinTable(name = "country_languages",
    joinColumns = @JoinColumn(name="country_id"),
    inverseJoinColumns = @JoinColumn(name="language_id"))
    private List<Language> languages;



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

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Date getNationalDay() {
        return nationalDay;
    }

    public void setNationalDay(Date nationalDay) {
        this.nationalDay = nationalDay;
    }

    public String getCountryCode2() {
        return countryCode2;
    }

    public void setCountryCode2(String countryCode2) {
        this.countryCode2 = countryCode2;
    }

    public String getCountryCode3() {
        return countryCode3;
    }

    public void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<CountryStats> getStats() {
        return stats;
    }

    public void setStats(List<CountryStats> stats) {
        this.stats = stats;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }
}
