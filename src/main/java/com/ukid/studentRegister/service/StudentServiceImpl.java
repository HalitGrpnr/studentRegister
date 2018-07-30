package com.ukid.studentRegister.service;

import com.ukid.studentRegister.domain.Student;
import com.ukid.studentRegister.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student get(String id) {
        return studentRepository.getOne(id);
    }

    @Override
    public Student add(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(String studentId) {
        Student student = studentRepository.getOne(studentId);
        studentRepository.delete(student);
    }

    @Override
    public Student update(String studentId, Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getByStudentName(String studentName) {
        return studentRepository.findStudentByName(studentName);
    }

    @Override
    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }
}
