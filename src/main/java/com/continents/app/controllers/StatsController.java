package com.continents.app.controllers;


import com.continents.app.dto.CountryStatsDTO;
import com.continents.app.dto.RegionContinentStatsDTO;
import com.continents.app.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
@CrossOrigin(origins = "http://localhost:4200")
public class StatsController {
    @Autowired
    private StatsService statsService;

    @GetMapping
    public ResponseEntity<?> stats(
            @RequestParam(defaultValue = "2000") Integer from,
            @RequestParam(defaultValue = "2020") Integer to,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return ResponseEntity.ok(statsService.statsBetweenYears(from, to, PageRequest.of(page, size)));
    }

    @GetMapping("/max-per-country")
    public ResponseEntity<List<CountryStatsDTO>> maxPerCountry() {
        return ResponseEntity.ok(statsService.maxGdpPerCapitaForAllCountries());
    }

    @GetMapping("/by-region")
    public ResponseEntity<List<RegionContinentStatsDTO>> byRegion(
            @RequestParam(required = false) Integer regionId,
            @RequestParam(defaultValue = "2000") Integer from,
            @RequestParam(defaultValue = "2020") Integer to,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        List<RegionContinentStatsDTO> rows = statsService.filterByRegionAndYears(regionId, from, to, page, size);
        return ResponseEntity.ok(rows);
    }
}
