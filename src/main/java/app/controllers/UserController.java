package app.controllers;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService){
//        this.userService = userService;
//    }
//
//
//    @RequestMapping("/{id}")
//    public String getUser(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "user/userInfo";
//    }

    @GetMapping()
    public String getUserPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "user/userInfo";
    }

}
