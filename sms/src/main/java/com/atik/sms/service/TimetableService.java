package com.atik.sms.service;

import com.atik.sms.entity.Timetable;
import com.atik.sms.repository.TimetableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {

    private final TimetableRepository timetableRepo;

    public TimetableService(TimetableRepository timetableRepo) {
        this.timetableRepo = timetableRepo;
    }

    public List<Timetable> getAllTimetables() {
        return timetableRepo.findAll();
    }

    public Timetable getTimetableById(Long id) {
        return timetableRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Timetable not found"));
    }

    public Timetable saveTimetable(Timetable timetable) {
        return timetableRepo.save(timetable);
    }

    public void deleteTimetable(Long id) {
        timetableRepo.deleteById(id);
    }

    // Extra queries
    public List<Timetable> getByClass(Long classId) {
        return timetableRepo.findBySchoolClass_Id(classId);
    }

    public List<Timetable> getByTeacher(Long teacherId) {
        return timetableRepo.findByTeacher_Id(teacherId);
    }

    public List<Timetable> getByDay(String day) {
        return timetableRepo.findByDayOfWeek(day);
    }
}
