package com.example._Found.__Found_Group_Assignment.Controllers;

import com.example._Found.__Found_Group_Assignment.Models.Product;
import com.example._Found.__Found_Group_Assignment.Models.User;
import com.example._Found.__Found_Group_Assignment.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    // Show users with optional search
    @GetMapping
    public String adminUsers(
            @RequestParam(name = "search", defaultValue = "") String search,
            @RequestParam(name = "page", defaultValue = "0") int page, // Current page
            Model model) {

        Pageable pageable = PageRequest.of(page, 5);
        Page<User> userPage;

        if (!search.isEmpty()) {
            userPage = userService.findByUsernamePageable(search, pageable);
        } else {
            userPage = userService.getAllUsersPageable(pageable);
        }

        model.addAttribute("users", userPage.getContent());
        model.addAttribute("search", search);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", userPage.getTotalPages());
        model.addAttribute("total", userPage.getTotalElements());
        model.addAttribute("hasPrevious", userPage.hasPrevious());
        model.addAttribute("hasNext", userPage.hasNext());
        model.addAttribute("pageSize", 5);

        int startIndex = page * 5 + 1;
        int endIndex = Math.min((page + 1) * 5, (int) userPage.getTotalElements());

        model.addAttribute("startIndex", startIndex);
        model.addAttribute("endIndex", endIndex);

        return "admin";
    }

    // Used for fetching data for updateUser_modal
    @GetMapping("/get/{id}")
    @ResponseBody
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Delete user
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    // Update user
    @PostMapping("/update")
    public String updateUser(@Valid @ModelAttribute("User") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { return "admin";}
        userService.saveUser(user);
        return "redirect:/admin";
    }
}