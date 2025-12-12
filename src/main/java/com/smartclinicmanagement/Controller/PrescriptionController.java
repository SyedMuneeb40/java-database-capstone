package com.smartclinicmanagement.Controller;


import com.smartclinicmanagement.Model.Prescription;
import com.smartclinicmanagement.repository.PrescriptionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    // Save new prescription
    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private TokenService tokenService;

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


    // Include token in path
    @PostMapping("/{token}")
    public ResponseEntity<Map<String, String>> savePrescription(
            @PathVariable String token,
            @RequestBody Prescription prescription) {

        // Validate token
        if (!tokenService.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        prescriptionService.save(prescription);
        return ResponseEntity.ok(Map.of("message", "Prescription saved successfully"));
    }

    // Delete prescription
    @GetMapping("/delete/{id}")
    String deletePrescription(@PathVariable("id") String id) {
        prescriptionRepository.deleteById(id);
        return "redirect:/prescriptions";
    }
}
