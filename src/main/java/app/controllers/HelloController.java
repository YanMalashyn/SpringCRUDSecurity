package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

@Controller
public class HelloController {
    @GetMapping(value = "/good")
    public String helloPage(){
        System.out.println("GOOOOOOODDDDD");
        return "good";
    }
    @PostConstruct
    public void adsd(){
        System.out.println("dasfsd");
    }

    @GetMapping(value = "/privet")
    @ResponseBody
    public String privet(){
        return "good";
    }

}
