package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dto.FeeDTO;
import com.example.schoolmanagement.entity.Fee;
import com.example.schoolmanagement.service.FeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
@CrossOrigin("*") // allow frontend access
public class FeeController {

    @Autowired
    private FeeService feeService;

//    public FeeController(FeeService feeService) {
//        this.feeService = feeService;
//    }

    @PostMapping("")
    public ResponseEntity<Fee> createFee(
            @RequestBody Fee fee

    ) {

        Fee saved = feeService.saveOrUpdate(fee);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<FeeDTO> getAllFees() {
        return feeService.getAllFeeDTOS();
    }

//    @GetMapping("/{id}")
//    public FeeDTO getFee(@PathVariable Long id) {
//        return feeService.getFeeById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteFee(@PathVariable Long id) {
//        feeService.deleteFee(id);
//    }
    
}
