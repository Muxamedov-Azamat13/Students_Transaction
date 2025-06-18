package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {

    private StudentRepository repository;

    public StudentsService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAll(){
        return repository.findAll();
    }

    public Student getById(Long id){
        return repository.findById(id).orElseThrow();
    }

    public Student create(Student student){
        return repository.save(student);
    }

    public Student update(Long id, Student updated){
        Student student = getById(id);
        student.setFirstName(updated.getFirstName());
        student.setLastName(updated.getLastName());
        student.setPhoneNumber(updated.getPhoneNumber());
        student.setCourse(updated.getCourse());
        student.setGroupName(updated.getGroupName());
        student.setMajor(updated.getMajor());
        return repository.save(student);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}
