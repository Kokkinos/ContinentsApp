package com.continents.app.dto;

public class CountryDTO {


    private Integer id;
    private String name;
    private Double area;
    private String countryCode2;

    public CountryDTO(Integer id, String name, Double area, String countryCode2) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.countryCode2 = countryCode2;
    }

    // Getters and setters
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

    public String getCountryCode2() {
        return countryCode2;
    }

    public void setCountryCode2(String countryCode2) {
        this.countryCode2 = countryCode2;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
