package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String registerUser(@ModelAttribute User user) {
        try {
            userService.registerUser(user);
            return "redirect:/"; // başarıyla kayıt olunca ana sayfaya dön
        } catch (Exception e) {
            return "redirect:/?error=" + e.getMessage();
        }
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password) {
        try {
            userService.loginUser(email, password);
            return "redirect:/"; // başarılı giriş
        } catch (Exception e) {
            return "redirect:/?error=" + e.getMessage();
        }
    }
}
