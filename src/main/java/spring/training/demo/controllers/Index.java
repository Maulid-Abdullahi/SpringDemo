package spring.training.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {

    @RequestMapping("/")
    public String home(){
        return "Default home...this overrides the index.html in static folder";
    }
}
