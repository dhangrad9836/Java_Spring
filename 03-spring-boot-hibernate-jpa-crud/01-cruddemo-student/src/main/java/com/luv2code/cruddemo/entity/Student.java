package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

@Entity //@Entity is needed so we can map to our database table
@Table(name="student") //@Table is needed so we can do the mapping to our table which is student
public class Student {

    //define fields
    //primary key
    @Id //this tells our code that we are using this for our primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //we need the @GeneratedValue(strategy = GenerationType.IDENTITY) so we know how to generate our primary key
    @Column(name="id") //this tell which column is our primary key
    private int id;

    //other fields
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    //define constructors
    //first create no arg constructor
    public Student(){
        //no arg constructor
    }

    //constructor w/o primary key
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }



    //define getters/setters with primary key

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //define toString() method


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
} //end of Student class
