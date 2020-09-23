package spring.training.demo.datastore.dao.instructor;

import spring.training.demo.datastore.model.instructor.Instructor;

import java.util.List;

public interface InstructorDaoI {

    List<Instructor> findAll();

    void save(Instructor instructor);

}