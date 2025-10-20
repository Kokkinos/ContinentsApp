package com.continents.app.repositories;

import com.continents.app.entities.CountryLanguage;
import com.continents.app.entities.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryLanguageRepo extends JpaRepository<CountryLanguage, CountryLanguageId> {

    List<CountryLanguage> findByCountry_Id(Integer countryId);

}
