package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dto.FeeDTO;
import com.example.schoolmanagement.entity.Fee;
import com.example.schoolmanagement.entity.Student;
import com.example.schoolmanagement.repository.FeeRepo;
import com.example.schoolmanagement.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeeService {

    private final FeeRepo feeRepo;
    private final StudentRepo studentRepo;

    public FeeService(FeeRepo feeRepo, StudentRepo studentRepo) {

        this.feeRepo = feeRepo;
        this.studentRepo = studentRepo;
    }

    public Fee saveFee(Fee fee, int student_id) {
        Student student=studentRepo.findById(student_id)
                .orElseThrow(() -> new RuntimeException("Student not found"+student_id));

        fee.setStudent(student);



        return feeRepo.save(fee);


    }

//    public List<FeeDTO> getAllFees() {
//        return feeRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
//    }

//    public FeeDTO getFeeById(Integer id) {
//        Fee fee = feeRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Fee not found"));
//        return mapToDTO(fee);
//    }

    public void deleteFee(Integer id) {
        feeRepo.deleteById(id);
    }

//    private FeeDTO mapToDTO(Fee fee) {
//        FeeDTO dto = new FeeDTO();
//        dto.setId(fee.getId());
//        dto.setStudentId(fee.getStudent().getId());
//        dto.setFeeCategory(fee.getFeeCategory());
//        dto.setFeeMonth(fee.getFeeMonth());
//        dto.setFeeAmount(fee.getFeeAmount());
//        dto.setPaymentDate(fee.getPaymentDate());
//        dto.setStudentName(fee.getStudent().getFirstName() + " " + fee.getStudent().getLastName());
//        dto.setStudentEmail(fee.getStudent().getEmail());
//        return dto;
//    }
}
