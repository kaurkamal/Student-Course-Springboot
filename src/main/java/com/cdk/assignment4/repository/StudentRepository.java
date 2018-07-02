package com.cdk.assignment4.repository;

import com.cdk.assignment4.model.Student;



import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by kaurk on 6/22/18.
 */


public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAll();

    Student findByFirstName(String fname);

    Student findById(int id);

}
