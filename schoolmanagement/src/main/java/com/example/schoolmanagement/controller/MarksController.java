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

    // ✅ Save or Update Marks
    @PostMapping("")
    public ResponseEntity<?> saveOrUpdate(@RequestBody Marks marks) {
        try {
            MarksDTO saved = marksService.saveOrUpdate(marks);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred");
        }
    }

    // ✅ Get All Marks (DTOs)
    @GetMapping("")
    public ResponseEntity<List<MarksDTO>> getAllMarks() {
        List<MarksDTO> all = marksService.getAllMarksDTOS();
        return ResponseEntity.ok(all);
    }

    // ✅ Delete Marks by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMarks(@PathVariable Integer id) {
        try {
            marksService.deleteById(id);
            return ResponseEntity.ok("Marks with ID " + id + " deleted successfully.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete failed");
        }
    }
}
