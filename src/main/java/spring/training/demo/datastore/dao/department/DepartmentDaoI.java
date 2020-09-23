package spring.training.demo.datastore.dao.department;

import spring.training.demo.datastore.model.department.Department;

import java.util.List;

public interface DepartmentDaoI {

    List<Department> findAll();

    void save(Department department);
}
