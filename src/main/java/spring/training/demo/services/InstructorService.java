package spring.training.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.training.demo.datastore.dao.department.DepartmentDaoI;
import spring.training.demo.datastore.dao.instructor.InstructorDaoI;
import spring.training.demo.datastore.model.department.Department;
import spring.training.demo.datastore.model.instructor.Instructor;

import java.util.List;

@Service
@Transactional
public class InstructorService {

    @Autowired
    private InstructorDaoI dao;

    @Autowired
    private DepartmentDaoI departmentDao;

    public List<Instructor> findAll() {
        return dao.findAll();
    }

    public void save(Instructor instructor) throws Exception{
        if (instructor == null)
            throw new Exception("Invalid instructor details");

        if (instructor.getIdNo() == null)
            throw new Exception("Id number is required!!!");

        List<Department> departments = departmentDao.findAll();

        boolean departmentExist = false;
        for (Department department : departments) {
            if (department.getId() == instructor.getDepartmentId()) {
                departmentExist = true;
                break;
            }

        }

        if (!departmentExist)
            throw new Exception("Department Does not exist");

        dao.save(instructor);
    }
}
