package spring.training.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.training.demo.datastore.model.instructor.Instructor;
import spring.training.demo.services.InstructorService;

import java.util.List;

@Controller
@RequestMapping(value = "/instructor")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @RequestMapping(value= {"/list/{id}","/orodha"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Instructor> list(@PathVariable(required = false) int id, @RequestParam("name") String name){
        System.out.println("Path variable: id " + id);
        System.out.println("Path variable: name " + name);

        return instructorService.findAll();
    }

    @PostMapping(value= "/save")
    public @ResponseBody String save(@RequestBody Instructor instructor){
        try {
            instructorService.save(instructor);
        }catch (Exception ex){
            return ex.getMessage();
        }

        return "success";
    }
}
