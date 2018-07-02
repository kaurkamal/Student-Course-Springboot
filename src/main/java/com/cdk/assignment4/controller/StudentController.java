package com.cdk.assignment4.controller;


import com.cdk.assignment4.model.Student;

import com.cdk.assignment4.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

/**
 * Created by kaurk on 6/22/18.
 */

@RestController
public class StudentController {


    final static Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/readStudent" , method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public List<Student> readStudent() {
        logger.error("Hitting the read end point");
        return studentService.readAllStudent();
    }

    @RequestMapping(value = "/saveStudent" , method = RequestMethod.POST , produces = TEXT_PLAIN_VALUE , consumes = APPLICATION_JSON_VALUE)
    public String addCar(@RequestBody Student student) {
        System.out.println(student);
        logger.error("Hitting the save student end point");
        int value = studentService.saveStudent(student);
        return "Student with id '" + value + " ' resource added successfully!";
    }

    @RequestMapping(value= "/deleteStudent/{id}", method = RequestMethod.DELETE, produces = TEXT_PLAIN_VALUE)
    public String deleteStudent(@PathVariable int id) {
        logger.error("Hitting the delete student end point");
        studentService.removeStudent(id);
        return "Student with id '" + id + "'resource deleted successfully!";
    }

    @RequestMapping(value = "/readStudent/{id}" , method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public Student readStudentById(@PathVariable  int id) {
        return studentService.readOneStudentById(id);
    }

        @RequestMapping(value = "/readStudentByFirstName/{fname}" , method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
        public Student readStudentByFname(@PathVariable  String fname) {
            return studentService.readStudentByfirstName(fname);
        }

    @RequestMapping(value = "updateStudent/{id}", method = RequestMethod.PUT, produces = TEXT_PLAIN_VALUE , consumes = APPLICATION_JSON_VALUE)
    public String updateStudent( @RequestBody Student student , @PathVariable int id) {
        logger.error("Hitting the update student end point");
        int newID = studentService.updateStudentById(student, id);
        return "Student with id '" + newID + " ' resource added successfully!";
    }

}
