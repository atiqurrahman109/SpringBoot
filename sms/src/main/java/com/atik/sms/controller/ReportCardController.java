package com.atik.sms.controller;

import com.atik.sms.dto.ReportCardDTO;
import com.atik.sms.service.ReportCardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/report-cards")
@CrossOrigin(origins = "http://localhost:4200")
public class ReportCardController {

    private final ReportCardService service;

    public ReportCardController(ReportCardService service) {
        this.service = service;
    }

    @GetMapping("/{studentId}/{examId}")
    public ReportCardDTO getReportCard(@PathVariable Long studentId,
                                       @PathVariable Long examId) {
        return service.generateReportCard(studentId, examId);
    }
}
