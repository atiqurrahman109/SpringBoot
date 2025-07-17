package com.emranhss.project.repository;

import com.emranhss.project.entity.PoliceStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPoliceStationRepo extends JpaRepository<PoliceStation,Integer> {

    List<PoliceStation> findByDistrictId(Integer districtId);
}
