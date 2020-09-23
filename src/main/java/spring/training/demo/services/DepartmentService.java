package spring.training.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.training.demo.datastore.dao.department.DepartmentDaoI;
import spring.training.demo.datastore.model.department.Department;

import java.util.List;

@Service
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentDaoI dao;

    public List<Department> findAll() {
        return dao.findAll();
    }

    public void save(Department department) throws Exception{
        dao.save(department);
    }

}
