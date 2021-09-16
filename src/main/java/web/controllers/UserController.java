package web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.models.User;
import web.service.UserService;

import java.security.Principal;

@Controller

public class UserController {

    private UserService service;
    private User u;
    private String rol;

    public UserController(UserService service) {
        this.service = service;
    }
    @GetMapping("/profile/{login}")
    public String index(Model model, Principal principal) {
        User user = service.getUserByLogin(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
