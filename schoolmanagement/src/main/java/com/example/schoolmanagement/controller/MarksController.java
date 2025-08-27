package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dto.MarksDTO;
import com.example.schoolmanagement.entity.Marks;
import com.example.schoolmanagement.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
@CrossOrigin("*")
public class MarksController {

    @Autowired
    private MarksService marksService;

    // ✅ Save or Update
    @PostMapping("")
    public ResponseEntity<?> saveOrUpdate(@RequestBody Marks marks) {
        try {
            Marks saved = marksService.saveOrUpdate(marks);
            return ResponseEntity.ok(saved);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred");
        }
    }

    // ✅ Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMarks(@PathVariable Integer id) {
        try {
            marksService.deleteById(id);
            return ResponseEntity.ok("Marks with ID " + id + " deleted successfully.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete failed");
        }
    }

    // ✅ Get All DTOs
    @GetMapping("")
    public ResponseEntity<List<MarksDTO>> getAllMarks() {
        List<MarksDTO> all = marksService.getAllMarksDTOS();
        return ResponseEntity.ok(all);
    }
}
