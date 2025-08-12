package service;

import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAll(){
        return studentRepo.findAll();
    }

    public Optional<Student> getById(Integer id){
        return studentRepo.findById(id);
    }

    public Student save(Student student){
        return studentRepo.save(student);
    }
    public void deleteById(Integer id){
        studentRepo.deleteById(id);
    }

    public Student getProfileByUserId(int userid){
        return studentRepo.findById(userid)
                .orElseThrow(() -> new RuntimeException("User not found!!"));

    }


    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    public Optional<Student> findById(Integer id)
    {return  studentRepo.findById(id);}

    }

