package com.ukid.studentRegister.repository;

import com.ukid.studentRegister.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
   Student findStudentByName(String studentName);
}

