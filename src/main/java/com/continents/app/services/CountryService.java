package com.continents.app.services;

import com.continents.app.dto.CountryDTO;
import com.continents.app.dto.LanguageDTO;
import com.continents.app.entities.Country;
import com.continents.app.repositories.CountryLanguageRepo;
import com.continents.app.repositories.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private CountryLanguageRepo countryLanguageRepoRepo;

    public List<CountryDTO> getAllCountries() {
        return countryRepo.findAll(Sort.by("name"))
                .stream()
                .map(c -> new CountryDTO(c.getName(), c.getArea(), c.getCountryCode2()))
                .collect(Collectors.toList());
    }

    public List<LanguageDTO> getLanguagesForCountry(String code) {
        Country country = countryRepo.findByCountryCode2(code).orElse(null);
        //todo: error handling
        return countryLanguageRepoRepo.findByCountry_Id(country.getId())
                .stream()
                .map(cl -> new LanguageDTO(cl.getLanguage().getLanguage(), cl.getOfficial()))
                .collect(Collectors.toList());

    }

}
