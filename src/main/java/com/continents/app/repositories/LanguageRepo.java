package com.continents.app.repositories;

import com.continents.app.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepo extends JpaRepository<Language, Integer> {

}
