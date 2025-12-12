package com.smartclinicmanagement.Controller;

import com.smartclinicmanagement.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username, @RequestParam String password, Model model) {
        // Simple login check (replace with DB authentication)
        if (username.equals("admin") && password.equals("password123")) {
            String token = jwtUtil.generateToken(username);
            model.addAttribute("token", token);
            return "redirect:/admin";
        }
        model.addAttribute("error", "Invalid credentials");
        return "login";
    }
}
