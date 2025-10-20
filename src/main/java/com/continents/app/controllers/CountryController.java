package com.continents.app.controllers;

import com.continents.app.dto.CountryDTO;
import com.continents.app.dto.LanguageDTO;
import com.continents.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryDTO>> getCountries() {
        return new ResponseEntity<>(countryService.getAllCountries(), HttpStatus.OK);
    }

    @GetMapping("/{code}/languages")
    public ResponseEntity<List<LanguageDTO>> getCountryLanguages(@PathVariable String code) {
        return new ResponseEntity<>(countryService.getLanguagesForCountry(code), HttpStatus.OK);
    }


}
