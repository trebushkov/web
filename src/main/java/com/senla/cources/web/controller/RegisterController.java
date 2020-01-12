package com.senla.cources.web.controller;

import com.senla.cources.web.domain.Role;
import com.senla.cources.web.domain.User;
import com.senla.cources.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String addUser(User user, Model model) {
        if (userService.findByUserName(user.getUsername()).isPresent()) {
            model.addAttribute("errorMessage", "Already exists");
            return "register";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user = userService.save(user);

        return "redirect:/login";
    }
}
