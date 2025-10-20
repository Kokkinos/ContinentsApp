package com.continents.app.entities;

import jakarta.persistence.*;

@Entity
@Table(name="country_languages")
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId id = new CountryLanguageId();

    @ManyToOne
    @MapsId("countryId")
    @JoinColumn(name="country_id")
    private Country country;

    @ManyToOne()
    @MapsId("languageId")
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name="official")
    private Boolean isOfficial;

    public CountryLanguageId getId() {
        return id;
    }

    public void setId(CountryLanguageId id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Boolean getOfficial() {
        return isOfficial;
    }

    public void setOfficial(Boolean official) {
        isOfficial = official;
    }
}
