package com.ukid.studentRegister.service;

import com.ukid.studentRegister.domain.Student;

import java.util.Collection;

public interface StudentService {
    Student get(String id);
    Student add(Student student);
    void delete(String studentId);
    Student update(String studentId, Student student);
    Student getByStudentName(String studentName);
    Collection<Student> getAll();
}
