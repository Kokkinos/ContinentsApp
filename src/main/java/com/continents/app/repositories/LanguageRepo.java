package com.continents.app.repositories;

import com.continents.app.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepo extends JpaRepository<Language, Integer> {

//    List<Language> findByLanguageContainingIgnoreCase(String language);

    @Query("SELECT l.language FROM Language l JOIN l.countries c WHERE c.id = :countryId")
    List<String> findLanguagesByCountryId(Integer countryId);
}
