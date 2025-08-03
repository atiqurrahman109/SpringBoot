package com.emranhss.project.service;

import com.emranhss.project.dto.DivisionResponse;
import com.emranhss.project.entity.Country;
import com.emranhss.project.entity.Division;
import com.emranhss.project.repository.ICountryRepo;
import com.emranhss.project.repository.IDivisionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService {

    @Autowired
    private IDivisionRepo divisionRepo;
    @Autowired
    private ICountryRepo countryRepo;

    public List<Division> getAllDivisions() {
        return divisionRepo.findAll();
    }

    public List<DivisionResponse> getAllDivisionDTOs() {
        return getAllDivisions().stream().map(div -> {
            DivisionResponse dto = new DivisionResponse();
            dto.setId(div.getId());
            dto.setName(div.getName());

            List<Integer> districtIds = div.getDistricts().stream()
                    .map(d -> d.getId())
                    .toList();

            dto.setDistricts(districtIds);

            return dto;
        }).toList();
    }

    public Division saveDivision(Division division) {
        if(division.getCountry()    != null) {
            long countryId = division.getCountry().getId();
            Country country = countryRepo.findById(countryId)
                    .orElseThrow(() -> new RuntimeException("Country not found WITH ID: " + countryId));

            division.setCountry(country);
        }

        return IDivisionRepo.save(division);
    }

}
