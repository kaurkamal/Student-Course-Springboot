package com.cdk.assignment4.service;


import com.cdk.assignment4.model.Course;
import com.cdk.assignment4.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kaurk on 6/22/18.
 */

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> readAllCourse() {
        return courseRepository.findAll();
    }

    @Transactional
    public int saveCourse(Course course) {
        //20 loc
        Course c = courseRepository.save(course);
        return  c.getCourseId();
    }
}
