package app.controllers;

import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String index (Model model){
        model.addAttribute("userList", userService.getListUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String getId(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "show";
    }



}
