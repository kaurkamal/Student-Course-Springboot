package com.cdk.assignment4.controller;


import com.cdk.assignment4.model.Course;
import com.cdk.assignment4.model.Student;
import com.cdk.assignment4.service.CourseService;
import com.cdk.assignment4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

/**
 * Created by kaurk on 6/22/18.
 */
@RestController
public class CourseController {

        @Autowired
        CourseService courseService;

        @RequestMapping(value = "/readCourse" , method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
        public List<Course> readCourse() {
            return courseService.readAllCourse();
        }

        @RequestMapping(value = "/saveCourse" , method = RequestMethod.POST , produces = TEXT_PLAIN_VALUE , consumes = APPLICATION_JSON_VALUE)
        public String addCar(@RequestBody Course course) {
            System.out.println(course);
            int value = courseService.saveCourse(course);
            return "Course with id '" + value + " ' resource added successfully!";
        }

}

