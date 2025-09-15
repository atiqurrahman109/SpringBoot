package com.atik.sms.controller;

import com.atik.sms.entity.Parent;
import com.atik.sms.service.ParentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parents")
public class ParentController {

    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping
    public List<Parent> getAllParents() {
        return parentService.getAllParents();
    }

    @GetMapping("/{id}")
    public Parent getParent(@PathVariable Long id) {
        return parentService.getParentById(id);
    }

    @PostMapping
    public Parent addParent(@RequestBody Parent parent) {
        return parentService.saveParent(parent);
    }

    @PutMapping("/{id}")
    public Parent updateParent(@PathVariable Long id, @RequestBody Parent parent) {
        parent.setId(id);
        return parentService.saveParent(parent);
    }

    @DeleteMapping("/{id}")
    public void deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
    }
}