package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dto.FeeDTO;
import com.example.schoolmanagement.dto.StudentDTO;
import com.example.schoolmanagement.entity.Fee;
import com.example.schoolmanagement.entity.Student;
import com.example.schoolmanagement.repository.FeeRepo;
import com.example.schoolmanagement.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeeService {

    @Autowired
    private FeeRepo feeRepo;
    @Autowired
    private StudentRepo studentRepo;

    public Fee saveOrUpdate(Fee fee) {
        Student student = studentRepo.findById(fee.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + fee.getStudent().getId()));


        fee.setStudent(student);


        return feeRepo.save(fee);
    }






    public List<FeeDTO> getAllFeeDTOS() {
        return feeRepo.findAll().stream().map(fee -> {
            FeeDTO dto = new FeeDTO();
            dto.setId(fee.getId());
            dto.setFeeAmount(fee.getFeeAmount());
            dto.setFeeCategory(fee.getFeeCategory());
            dto.setFeeMonth(fee.getFeeMonth());
            dto.setPaymentDate(fee.getPaymentDate());

            Student student = fee.getStudent();
            if (student != null) {
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setId(student.getId());
                studentDTO.setFirstName(student.getFirstName());
                studentDTO.setClas(student.getClas());

                dto.setStudent(studentDTO);





            }
            return dto;
        }).toList();
    }

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
