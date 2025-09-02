package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dto.ClassScheduleDTO;
import com.example.schoolmanagement.entity.ClassSchedule;
import com.example.schoolmanagement.entity.Teacher;
import com.example.schoolmanagement.repository.ClassScheduleRepo;
import com.example.schoolmanagement.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassScheduleService {



        @Autowired
        private ClassScheduleRepo classScheduleRepo;
        @Autowired
        private TeacherRepo teacherRepo;

//        // Create or Update
//        public ClassSchedule saveSchedule(ClassSchedule schedule) {
//            return classScheduleRepo.save(schedule);
//        }
//
//        // Read all
//        public List<ClassSchedule> getAllSchedules() {
//            return classScheduleRepo.findAll();
//        }
//
//        // Read by ID
//        public Optional<ClassSchedule> getScheduleById(Integer id) {
//            return classScheduleRepo.findById(id);
//        }
//
//        // Delete
//        public void deleteSchedule(Integer id) {
//            classScheduleRepo.deleteById(id);
//        }








//    test



    public List<ClassSchedule> getAllSchedules() {
        return classScheduleRepo.findAll();
    }

    public ClassSchedule saveOrUpdate(ClassSchedule classSchedule) {
        Teacher teacher = teacherRepo.findById(classSchedule.getTeacher().getId())
                .orElseThrow(() -> new RuntimeException("Production Order not found with id: " + classSchedule.getTeacher().getId()));


        classSchedule.setTeacher(teacher);


        return  classScheduleRepo.save(classSchedule);
    }



    public List<ClassScheduleDTO> getAllClassScheduleDTOS() {
        return dayWiseProductionRepo.findAll().stream().map(dayWise -> {
            DayWiseProductionResponseDTO dto = new DayWiseProductionResponseDTO();

            dto.setId(dayWise.getId());
            dto.setUpdatedDate(dayWise.getUpdatedDate());

            dto.setShortSQty(dayWise.getShortSQty());
            dto.setShortMQty(dayWise.getShortMQty());
            dto.setShortLQty(dayWise.getShortMQty());
            dto.setShortXLQty(dayWise.getShortXLQty());

            dto.setFullSQty(dayWise.getFullSQty());
            dto.setFullMQty(dayWise.getFullMQty());
            dto.setFullLQty(dayWise.getFullLQty());
            dto.setFullXLQty(dayWise.getFullXLQty());


            ProductionOrder order = dayWise.getProductionOrder();
            if (order != null) {
                ProductionOrderResponseDTO productionOrderResponseDTO = new ProductionOrderResponseDTO();
                productionOrderResponseDTO.setId(order.getId());

                dto.setProductionOrder(productionOrderResponseDTO);


            }

            Order or = dayWise.getOrder();
            if (or != null) {
                OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
                orderResponseDTO.setId(or.getId());

                dto.setOrder(orderResponseDTO);
            }


            return dto;
        }).toList();
    }



    }


