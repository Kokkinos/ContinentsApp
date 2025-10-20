package com.continents.app.services;

import com.continents.app.dto.RegionDTO;
import com.continents.app.entities.Region;
import com.continents.app.repositories.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionRepo regionRepo;


    public List<RegionDTO> getRegions() {
        List<Region> regions = regionRepo.findAll();
        return regions.stream().map(region -> new RegionDTO(region.getName())).toList();
    }
}
