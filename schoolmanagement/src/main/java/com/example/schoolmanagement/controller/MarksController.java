package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dto.MarksDTO;
import com.example.schoolmanagement.entity.Marks;
import com.example.schoolmanagement.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
@CrossOrigin("*")
public class MarksController {
    @Autowired
    private MarksService marksService;

   //✅ Save or Update Marks
    @PostMapping("")
    public Marks saveOrUpdate(@RequestBody Marks marks) {
        return marksService.saveOrUpdate(marks);
    }

    // ✅ Delete Marks by ID
    @DeleteMapping("/{id}")
    public String deleteMarks(@PathVariable Integer id) {
        marksService.deleteById(id);
        return "Marks with ID " + id + " deleted successfully.";
    }

    // ✅ Get All Marks as DTO
    @GetMapping("")
    public List<MarksDTO> getAllMarks() {
        return marksService.getAllMarksDTOS();
    }


}
