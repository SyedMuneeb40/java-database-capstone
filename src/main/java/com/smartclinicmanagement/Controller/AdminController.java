package com.smartclinicmanagement.Controller;

import com.smartclinicmanagement.Model.Doctor;
import com.smartclinicmanagement.Service.DoctorService;
import com.smartclinicmanagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "admin-dashboard";
    }

    @PostMapping("/add-doctor")
    public String addDoctor(@ModelAttribute Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/admin";
    }

    @GetMapping("/delete-doctor/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return "redirect:/admin";
    }
}
