package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);	}

	//command line runner is from springboot framework	....for creating a command line application
	//this will execute after the beans have been loaded
	//we've injected the StudentDao inside the CommandLineRunner
	//@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		//lambda expression
		return runner -> {
			//createStudent(studentDAO); we passed int the DAO inside the createMultipleStudents() method
			//this is our own custom code for interaction with the database

			createMultipleStudents(studentDAO);
			
			//readStudent(studentDAO);
			
			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);
		};
	}//end of commandlinerunner

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on the id: primary key
			//we will get student with id of 1
			int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to "Scooby"		//remember that we are using the setter method setFirstName
		System.out.println("Updating student...");
		myStudent.setFirstName("Johnn");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated student: " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Duck");

		//display a list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of students using method we created findAll();
		List<Student> theStudents = studentDAO.findAll();

		//display a list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy", "Duck", "Daffy@luv2code.com");

		// save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of the saved student
			//remember that .getId() is from our Student class from the getters/setter
		int theId = tempStudent.getId();	//theId to store the id of the student
		System.out.println("Saved student. Generated id: " + theId);

		//retrieve student based on the id: primary key
			//we will pass in theId from what we created from above to retrieve the id
		System.out.println("Retrieving the student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create the student objects
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("John", "Doe", "John@luv2code.com");
		Student tempStudent2 = new Student("Laura", "Doe", "Laura@luv2code.com");
		Student tempStudent3 = new Student("Mike", "Doe", "Mike@luv2code.com");

		//save the student object (persist the objects)
		System.out.println("Saving the student objects...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}




} ///end class CruddemoApplication








