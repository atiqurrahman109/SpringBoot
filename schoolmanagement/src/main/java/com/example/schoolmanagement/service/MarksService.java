package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dto.MarksDTO;
import com.example.schoolmanagement.entity.Exam;
import com.example.schoolmanagement.entity.Marks;
import com.example.schoolmanagement.entity.Student;
import com.example.schoolmanagement.repository.ExamRepo;

import com.example.schoolmanagement.repository.MarksRepo;

import com.example.schoolmanagement.repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarksService {

    @Autowired
    private MarksRepo marksRepo;

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ExamRepo examrepo;



    // Save or Update

    public Marks saveOrUpdate(Marks marks) {
        Student student = studentRepo.findById(marks.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("Marks not found with id: " + marks.getStudent().getId()));

        Exam exam = examrepo.findById(marks.getExam().getId())
                .orElseThrow(() -> new RuntimeException("Exam not found with id: " + marks.getExam().getId()));

        marks.setStudent(student);
        marks.setExam(exam);

        return marksRepo.save(marks);
    }


    public void deleteById(Integer id) {
        marksRepo.deleteById(id);
    }
   


//    // ✅ New Service Method: Get BOMs by Style Code
//    public List<BOM> getBOMsByStyleCode(String styleCode) {
//        return bomRepo.findAllByStyleCode(styleCode);
//    }


    // ✅ Get BOMs by Style Code and return as DTOs
    public List<BomResponseDTO> getBOMsByStyleCode(String styleCode) {
        List<BOM> boms = bomRepo.findAllByStyleCode(styleCode);

        return boms.stream().map(bom -> {
            // Map UOM
            UOM uom = bom.getUom();
            UomResponseDTO uomDto = null;
            if (uom != null) {
                uomDto = new UomResponseDTO();
                uomDto.setId(uom.getId());
                uomDto.setProductName(uom.getProductName());
                uomDto.setSize(uom.getSize());
                uomDto.setBody(uom.getBody());
                uomDto.setSleeve(uom.getSleeve());
                uomDto.setPocket(uom.getPocket());
                uomDto.setWastage(uom.getWastage());
                uomDto.setShrinkage(uom.getShrinkage());
                uomDto.setBaseFabric(uom.getBaseFabric());
            }

            // Map BomStyle
            BomStyle style = bom.getBomStyle();
            BomStyleResponseDTO styleDto = null;
            if (style != null) {
                styleDto = new BomStyleResponseDTO();
                styleDto.setId(style.getId());
                styleDto.setStyleCode(style.getStyleCode());
                styleDto.setStyleType(style.getStyleType());
                styleDto.setDescription(style.getDescription());
            }

            // Map BOM
            BomResponseDTO bomDto = new BomResponseDTO();
            bomDto.setId(bom.getId());
            bomDto.setSerial(bom.getSerial());
            bomDto.setMaterial(bom.getMaterial());
            bomDto.setUnit(bom.getUnit());
            bomDto.setQuantity(bom.getQuantity());
            bomDto.setUnitPrice(bom.getUnitPrice());
            bomDto.setTotalCost(bom.getTotalCost());
            bomDto.setUom(uomDto);
            bomDto.setBomStyle(styleDto);

            return bomDto;
        }).collect(Collectors.toList());
    }
}
