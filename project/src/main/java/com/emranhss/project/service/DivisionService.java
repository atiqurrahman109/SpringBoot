package com.emranhss.project.service;

import com.emranhss.project.dto.DivisionResponse;
import com.emranhss.project.entity.Division;
import com.emranhss.project.repository.IDivisionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService {

    @Autowired
    private IDivisionRepo divisionRepository;

    public List<Division> getAllDivisions() {
        return divisionRepository.findAll();
    }

    public Division saveDivision(Division division) {
        return divisionRepository.save(division);
    }

}
