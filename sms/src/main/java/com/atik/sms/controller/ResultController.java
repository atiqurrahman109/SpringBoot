package com.atik.sms.controller;

import com.atik.sms.entity.Result;

import com.atik.sms.service.ResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/result")
@CrossOrigin(origins = "http://localhost:4200")
public class ResultController {
    private final ResultService service;

    public ResultController(ResultService service) {
        this.service = service;
    }

    @GetMapping
    public List<Result> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Result add(@RequestBody Result result) {
        return service.save(result);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
