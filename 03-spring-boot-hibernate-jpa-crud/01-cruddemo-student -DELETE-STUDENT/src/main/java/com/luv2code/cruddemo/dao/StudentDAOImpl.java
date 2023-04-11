package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO{

    //define field for entity manager which is provided from Spring
    private EntityManager entityManager;

    //REMOVE THE RED UNDERLINE IN entityManager...note it's not an error just intellij
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    //inject entity manager using construction injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method

    @Override
    @Transactional  //to update the database and exceptions
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create query and ignore the RED Squiggly line underneath "FROM"
        //remember that Student is the name of our Student class and lastName is the field inside our Student class
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        //return query results...note that .getResultList() comes default from EntityManager
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //Create query to find students by last name...note we are using :theData think of this as a placeholder since we are not actually hardcoding a specific lastname
        //but to query from the StudentDAO and we will pass in theLastName
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        //set query parameters
        theQuery.setParameter("theData", theLastName);

        //return query results...note that .getResultList() comes default from EntityManager
        return theQuery.getResultList();


    }

    @Override
    @Transactional  //since we are actually doing an update to the database we need @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the student
        Student theStudent = entityManager.find(Student.class, id);

        //delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
   public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }
}
