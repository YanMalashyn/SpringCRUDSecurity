package app.controllers;

import app.model.User;
import app.service.RoleService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String index (Model model){
        model.addAttribute("userList", userService.getListUsers());
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin/index";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Long id, Model model) {

        model.addAttribute("user", userService.getUserById(id));
        return "admin/userInfo";
    }

    @GetMapping("/user/add")
    public String addUser(Model model) {

        model.addAttribute("newUser", new User());
        model.addAttribute("roleList", roleService.getAllRoles());

        return "admin/newUser";
    }

    @PostMapping("/user/add")
    public String addNewUser(@ModelAttribute("newUser") User newUser,
                             @RequestParam(value = "rolesIdSelect") Long idRole) {

        userService.saveUser(newUser, idRole);
        return "redirect:/admin/";
    }

    @GetMapping("/user/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/";
    }

    @GetMapping("/user/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/editUser";
    }

    @PatchMapping("/user/{id}")
    public String editUser(@PathVariable("id") Long id, @ModelAttribute("user") User user) {

        userService.updateUser(id, user);
        return "redirect:/admin/user/"+id;
    }
}
