package com.cdk.assignment4.model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


/**
 * Created by kaurk on 6/21/18.
 */
@Entity
@Table(name = "Student_detail")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String firstName;
    String lastName;
    int age;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "s-Id")
    Set<Course> courseSet = new HashSet<>();


    public Student(){}

    public Student(String firstName, String lastName, int age, Set<Course> courseSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.courseSet = courseSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", courseSet=" + courseSet +
                '}';
    }
}
