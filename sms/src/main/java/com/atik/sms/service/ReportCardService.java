package com.atik.sms.service;

import com.atik.sms.dto.ReportCardDTO;
import com.atik.sms.entity.Exam;
import com.atik.sms.entity.Result;
import com.atik.sms.entity.Student;
import com.atik.sms.repository.ExamRepository;
import com.atik.sms.repository.ResultRepository;
import com.atik.sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportCardService {

    private final StudentRepository studentRepo;
    private final ExamRepository examRepo;
    private final ResultRepository resultRepo;

    public ReportCardService(StudentRepository studentRepo,
                             ExamRepository examRepo,
                             ResultRepository resultRepo) {
        this.studentRepo = studentRepo;
        this.examRepo = examRepo;
        this.resultRepo = resultRepo;
    }

    public ReportCardDTO generateReportCard(Long studentId, Long examId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Exam exam = examRepo.findById(examId)
                .orElseThrow(() -> new RuntimeException("Exam not found"));

        List<Result> results = resultRepo.findByStudentIdAndExamId(studentId, examId);

        List<ReportCardDTO.SubjectMarks> marks = results.stream()
                .map(r -> new ReportCardDTO.SubjectMarks(
                        r.getExam().getSubject(),
                        r.getMarks(),
                        r.getGrade()
                ))
                .collect(Collectors.toList());

        return ReportCardDTO.builder()
                .studentName(student.getFirstname() + " " + student.getLastname())
                .className(student.getSchoolClass().getClassName())
                .examName(exam.getExamName())
                .marks(marks)
                .build();
    }
}