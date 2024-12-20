package com.continents.app.controllers;

import com.continents.app.dto.CountryDTO;
import com.continents.app.entities.Country;
import com.continents.app.entities.Region;
import com.continents.app.repositories.CountryRepo;
import com.continents.app.repositories.LanguageRepo;
import com.continents.app.repositories.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NationController {

    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private RegionRepo regionRepo;
    @Autowired
    private LanguageRepo languageRepo;


    @GetMapping("/countries")
    public List<CountryDTO> countries() {
        return countryRepo.findAllCountriesOrderderByName();
    }

    @GetMapping("/countries/{id}")
    public Country country(@PathVariable int id) {
        return countryRepo.findById(id).orElse(null);
    }

    @GetMapping("/regions/{id}")
    public Region region(@PathVariable int id) {
        return regionRepo.findById(id).orElse(null);
    }

    @GetMapping("/countries/{countryId}/languages")
    public List<String> languages(@PathVariable int countryId) {
        return languageRepo.findLanguagesByCountryId(countryId);
    }
}
