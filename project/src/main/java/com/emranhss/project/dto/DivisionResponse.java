package com.emranhss.project.dto;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionResponse{


    private int id;
    private String name;
    private List<Integer> districts;  // Just District IDs

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getDistricts() {
        return districts;
    }

    public void setDistricts(List<Integer> districts) {
        this.districts = districts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
