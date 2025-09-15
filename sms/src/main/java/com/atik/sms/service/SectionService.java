package com.atik.sms.service;

import com.atik.sms.entity.Section;
import com.atik.sms.repository.SectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public Section createSection(Section section) {
        return sectionRepository.save(section);
    }

    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    public Optional<Section> getSectionById(Long id) {
        return sectionRepository.findById(id);
    }

    public List<Section> getSectionsByClassId(Long classId) {
        return sectionRepository.findBySchoolClassId(classId);
    }

    public Section updateSection(Long id, Section updatedSection) {
        return sectionRepository.findById(id).map(section -> {
            section.setName(updatedSection.getName());
            section.setSchoolClass(updatedSection.getSchoolClass());
            return sectionRepository.save(section);
        }).orElseThrow(() -> new RuntimeException("Section not found with id " + id));
    }

    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);
    }
}
