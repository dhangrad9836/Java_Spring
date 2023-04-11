package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    //add new method to interface for retrieving Primary key
    Student findById(Integer id);

    //New method to return list of students
    List<Student> findAll();

    //New method to find by last name
    List<Student> findByLastName(String theLastName);

    //Add method to UPDATE Student object
    void update(Student student);

    //Add delete method
    void delete(Integer id);

    //To delete all students
    int deleteAll();

}
