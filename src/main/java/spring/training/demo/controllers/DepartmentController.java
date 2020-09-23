package spring.training.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.training.demo.datastore.model.department.Department;
import spring.training.demo.services.DepartmentService;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Department> list(){
        return departmentService.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody String save(@RequestBody Department department){

        try {
            departmentService.save(department);

        }catch (Exception ex){
            return ex.getMessage();
        }

        return "success";
    }

}
