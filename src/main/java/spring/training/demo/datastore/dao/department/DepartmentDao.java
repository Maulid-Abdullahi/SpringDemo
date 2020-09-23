package spring.training.demo.datastore.dao.department;

import org.springframework.stereotype.Repository;
import spring.training.demo.datastore.model.department.Department;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DepartmentDao implements DepartmentDaoI  {

    @PersistenceContext
    private EntityManager em;

    public List<Department> findAll() {
        return em.createQuery("from " + Department.class.getName()).getResultList();
    }

    public void save(Department department){
        em.merge(department);

    }
}
