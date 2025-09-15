package com.atik.sms.service;

import com.atik.sms.entity.Fee;
import com.atik.sms.entity.Student;
import com.atik.sms.repository.FeeRepository;
import com.atik.sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeeService {

    private final FeeRepository feeRepo;
    private final StudentRepository studentRepo;

    public FeeService(FeeRepository feeRepo, StudentRepository studentRepo) {
        this.feeRepo = feeRepo;
        this.studentRepo = studentRepo;
    }

    // 🔹 Get all fees
    public List<Fee> getAll() {
        return feeRepo.findAll();
    }

    // 🔹 Save or update fee
    public Fee save(Fee fee) {
        return feeRepo.save(fee);
    }

    // 🔹 Delete fee
    public void delete(Long id) {
        feeRepo.deleteById(id);
    }

    // 🔹 Get students who have not paid for a given month
    public List<Student> getStudentsWithUnpaidFees(String month) {
        List<Student> allStudents = studentRepo.findAll();

        List<Long> paidStudentIds = feeRepo.findByFeeMonth(month)
                .stream()
                .map(f -> f.getStudent().getId())
                .toList();

        return allStudents.stream()
                .filter(s -> !paidStudentIds.contains(s.getId()))
                .collect(Collectors.toList());
    }
}
