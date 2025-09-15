package com.atik.sms.controller;

import com.atik.sms.entity.Fee;
import com.atik.sms.entity.Student;
import com.atik.sms.service.FeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
public class FeeController {

    private final FeeService feeService;

    public FeeController(FeeService feeService) {
        this.feeService = feeService;
    }

    // 🔹 Get all fees
    @GetMapping
    public List<Fee> getAllFees() {
        return feeService.getAll();
    }

    // 🔹 Save new fee
    @PostMapping
    public Fee saveFee(@RequestBody Fee fee) {
        return feeService.save(fee);
    }

    // 🔹 Delete fee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFee(@PathVariable Long id) {
        feeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // 🔹 Get unpaid students for a given month
    @GetMapping("/unpaid/{month}")
    public List<Student> getUnpaidStudents(@PathVariable String month) {
        return feeService.getStudentsWithUnpaidFees(month);
    }
}