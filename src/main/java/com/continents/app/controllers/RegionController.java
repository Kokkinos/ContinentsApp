package com.continents.app.controllers;

import com.continents.app.dto.RegionDTO;
import com.continents.app.entities.Region;
import com.continents.app.repositories.RegionRepo;
import com.continents.app.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
@CrossOrigin(origins = "http://localhost:4200")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    public ResponseEntity<List<RegionDTO>> getAllRegions() {
        return ResponseEntity.ok(regionService.getRegions());
    }
}
