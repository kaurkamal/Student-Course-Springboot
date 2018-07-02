package com.cdk.assignment4.service;

import com.cdk.assignment4.Exception.StudentNotFoundException;
import com.cdk.assignment4.model.Student;
import com.cdk.assignment4.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kaurk on 6/22/18.
 */
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> readAllStudent() {
        return studentRepository.findAll();
    }

    @Transactional
    public int saveStudent(Student student) {
        Student s = studentRepository.save(student);
        return  s.getId();
    }

    @Transactional
    public void removeStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public  Student readOneStudentById( int id) {

        Student student = studentRepository.findById(id);
        if(student == null) {
            throw new StudentNotFoundException(id , "Student not found");
        }
        else
        return student;
    }

    @Transactional
    public Student readStudentByfirstName( String fname) {
        return studentRepository.findByFirstName(fname);
    }

    @Transactional
    public int updateStudentById(Student student, int id) {
        studentRepository.save(student);
        return student.getId();
    }
}
