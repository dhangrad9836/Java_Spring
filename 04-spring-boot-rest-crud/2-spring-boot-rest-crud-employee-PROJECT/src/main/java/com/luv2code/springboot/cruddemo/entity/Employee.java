package com.luv2code.springboot.cruddemo.entity;


import ch.qos.logback.core.model.conditional.ElseModel;
import jakarta.persistence.*;

//step 3 of our design create the employee entity and map it to the database with @Entity @Table
@Entity
@Table(name="employee") //name="employee" is the name of our database table name
public class Employee {

    //define fields and annotations for column names
    @Id     //defines the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //also for primary key
    @Column(name="id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;

    //define constructors
        //define no-arg constructor
    public Employee(){

    }
    //note that we don't include the id b/c it's automatically constructed
    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    //define getter/setter
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

    //define toString

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}//end Employee class
