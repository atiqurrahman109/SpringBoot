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

    @PostMapping("/save")
    public Marks saveMarks(@RequestBody MarksDTO marksDTO) {
        return marksService.saveMarks(marksDTO);
    }
    @GetMapping("/all")
    public List<MarksDTO> getAllMarks() {
        return marksService.getAllMarks();
    }
    @GetMapping("/{id}")
        public MarksDTO getMarks(@PathVariable int id){
            return marksService.getMarksById(id);
        }
    @DeleteMapping("/delete/{id}")
        public String deleteMarks(@PathVariable int id){
            marksService.deleteMarks(id);
            return "marks delete successfully";

        }


}
