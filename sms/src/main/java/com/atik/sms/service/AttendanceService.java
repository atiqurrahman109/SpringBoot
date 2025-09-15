package com.atik.sms.service;

import com.atik.sms.entity.Attendance;
import com.atik.sms.repository.AttendanceRepository;
import com.atik.sms.repository.FeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttendanceService {

    private final AttendanceRepository repo;

    public AttendanceService(AttendanceRepository repo) {
        this.repo = repo;
    }

    public List<Attendance> getAll() {
        return repo.findAll();
    }

    public Attendance save(Attendance attendance) {
        return repo.save(attendance);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

