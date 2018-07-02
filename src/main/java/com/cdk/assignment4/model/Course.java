package com.cdk.assignment4.model;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by kaurk on 6/21/18.
 */
@Entity
@Table(name = "Course_detail")
public class Course {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    int courseId;
    String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    Course() {}


    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
