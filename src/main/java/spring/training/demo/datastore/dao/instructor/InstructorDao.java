package spring.training.demo.datastore.dao.instructor;

import org.springframework.stereotype.Repository;
import spring.training.demo.datastore.model.department.Department;
import spring.training.demo.datastore.model.instructor.Instructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class InstructorDao implements InstructorDaoI {

    @PersistenceContext
    private EntityManager em;

    public List<Instructor> findAll() {
        return em.createQuery("from " + Instructor.class.getName()).getResultList();
    }

    public void save(Instructor instructor){
        if (instructor.getDepartmentId() != 0)
            instructor.setDepartment(em.getReference(Department.class, instructor.getDepartmentId()));

        if (instructor.getDepartment() != null && instructor.getDepartment().getId() == 0)
            instructor.setDepartment(em.merge(instructor.getDepartment()));

        em.merge(instructor);

    }
}
