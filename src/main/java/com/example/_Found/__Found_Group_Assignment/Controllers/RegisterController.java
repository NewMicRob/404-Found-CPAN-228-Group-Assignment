package com.example._Found.__Found_Group_Assignment.Controllers;

import com.example._Found.__Found_Group_Assignment.Models.User;
import com.example._Found.__Found_Group_Assignment.Repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String getRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    public String registerUserToDB(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            result.rejectValue("username", "error.username", "Username has been taken");
        }

        if (result.hasErrors()) {
            return "register";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return "redirect:/login?success";
    }
}