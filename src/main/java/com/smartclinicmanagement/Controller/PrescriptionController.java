package com.smartclinicmanagement.Controller;


import com.smartclinicmanagement.Model.Prescription;
import com.smartclinicmanagement.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    // List all prescriptions
    @GetMapping
    public String listPrescriptions(Model model) {
        List<Prescription> prescriptions = prescriptionRepository.findAll();
        model.addAttribute("prescriptions", prescriptions);
        return "prescriptions-list"; // Thymeleaf page
    }

    // Add new prescription form
    @GetMapping("/add")
    public String addPrescriptionForm(Model model) {
        model.addAttribute("prescription", new Prescription());
        return "prescription-add";
    }

    // Save new prescription
    @PostMapping("/save")
    public String savePrescription(@ModelAttribute("prescription") Prescription prescription) {
        prescriptionRepository.save(prescription);
        return "redirect:/prescriptions";
    }

    // Delete prescription
    @GetMapping("/delete/{id}")
    public String deletePrescription(@PathVariable("id") String id) {
        prescriptionRepository.deleteById(id);
        return "redirect:/prescriptions";
    }
}
