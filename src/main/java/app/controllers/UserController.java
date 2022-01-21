package app.controllers;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//     @GetMapping()
//    public String index (Model model){
//        model.addAttribute("userList", userService.getListUsers());
//        return "index";
//    }

    @RequestMapping("/{id}")
    public String getUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/userInfo";
    }

//    @GetMapping("/add")
//    public String addUser(@ModelAttribute("newUser") User newUser) {
//        return "newUser";
//    }
//
//    @PostMapping("/add")
//    public String addNewUser(@ModelAttribute("newUser") User newUser) {
//        if(Objects.nonNull(newUser) && newUser.getAge() != 0 && newUser.getFirstName() != null && newUser.getLastName() != null) {
//            userService.saveUser(newUser);
//        }
//        return "redirect:/user";
//    }
//
//    @GetMapping("/{id}/delete")
//    public String deleteUser(@PathVariable("id") int id) {
//        userService.deleteUser(id);
//        return "redirect:/user";
//    }

//    @GetMapping("/{id}/edit")
//    public String editUser(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userService.getUserById(id));
//        System.out.println("ok");
//        return "editUser";
//    }
//
//    @PatchMapping("/{id}")
//    public String editUser(@PathVariable("id") int id, @ModelAttribute("user") User user) {
//        userService.updateUser(user);
//        return "redirect:/user/"+id;
//    }
}
