package com.cdk.assignment4;

import com.cdk.assignment4.controller.StudentController;
import com.cdk.assignment4.model.Student;
import com.cdk.assignment4.service.StudentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by kaurk on 6/25/18.
 */
public class TestStudentController {

    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveStudent() {
        Student student = Mockito.mock(Student.class);
        student.setId(7);
        student.setFirstName("Arsh");
        student.setAge(23);
        Mockito.when(student.getId()).thenReturn(7);
        Mockito.when(student.getFirstName()).thenReturn("Arsh");
        Mockito.when(student.getAge()).thenReturn(23);
        studentService.saveStudent(student);
        Assert.assertEquals(7, student.getId());
        Assert.assertEquals("Arsh", student.getFirstName());
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getAge());
    }

    @Test
    public void testReadStudent() {
        Student student = Mockito.mock(Student.class);
        student.setId(8);
        student.setAge(34);
        studentService.saveStudent(student);
        Mockito.when(studentService.readOneStudentById(8)).thenReturn(student);
        Mockito.when(student.getId()).thenReturn(8);
        Mockito.when(student.getAge()).thenReturn(34);

        Assert.assertEquals(student,studentService.readOneStudentById(8));
        Assert.assertEquals(8,student.getId());
        Assert.assertEquals(34,student.getAge());

        System.out.println(student);
        System.out.println(student.getAge());
        System.out.println(student.getId());
    }



    @Test
    public void testRemoveStudent() {
        Student student = Mockito.mock(Student.class);
        student.setId(8);
        student.setAge(34);
        studentService.saveStudent(student);
//        Mockito.when(student.getId()).thenReturn(null);
//        Mockito.when(student.getAge()).thenReturn(null);
        studentService.removeStudent(8);
//        Assert.assertEquals(null,student.getId());
//        Assert.assertEquals(null,student.getAge());
        verify(studentService, times(1)).removeStudent(8);


    }


    @Test
    public void testUpdateStudent() {
        Student student = Mockito.mock(Student.class);
        student.setId(8);
        student.setAge(34);
        studentService.saveStudent(student);
        Mockito.when(student.getAge()).thenReturn(24);
        student.setAge(24);
        studentService.updateStudentById(student,8);
        Assert.assertEquals(24,student.getAge());
        System.out.println(student.getAge());

    }


}
