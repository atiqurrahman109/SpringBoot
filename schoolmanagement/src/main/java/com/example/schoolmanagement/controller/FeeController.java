package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dto.FeeDTO;
import com.example.schoolmanagement.entity.Fee;
import com.example.schoolmanagement.service.FeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
@CrossOrigin(origins = "*") // allow frontend access
public class FeeController {

    @Autowired
    private FeeService feeService;

//    public FeeController(FeeService feeService) {
//        this.feeService = feeService;
//    }

    @PostMapping("")
    public Fee saveFee(@RequestBody Fee b,
                        @RequestParam Integer student_id) {
        return feeService.saveFee(b, student_id);
    }

//    @GetMapping
//    public List<FeeDTO> getAllFees() {
//        return feeService.getAllFees();
//    }
//
//    @GetMapping("/{id}")
//    public FeeDTO getFee(@PathVariable Long id) {
//        return feeService.getFeeById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteFee(@PathVariable Long id) {
//        feeService.deleteFee(id);
//    }
    njhgdresdfggh
}
