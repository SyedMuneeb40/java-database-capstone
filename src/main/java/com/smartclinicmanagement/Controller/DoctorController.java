package com.smartclinicmanagement.Controller;





import com.smartclinicmanagement.Model.Appointment;
import com.smartclinicmanagement.Model.Doctor;
import com.smartclinicmanagement.Security.JwtUtil;
import com.smartclinicmanagement.Service.DoctorService;
import com.smartclinicmanagement.repository.AppointmentRepository;
import com.smartclinicmanagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Controller
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;


    @Autowired
    private DoctorService doctorService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private JwtUtil jwtUtil; // For token validation

    // Doctor Dashboard
    @GetMapping("/doctor/dashboard")
    public String doctorDashboard(Model model) {
        // In real app, get currently logged-in doctor
        // For demo, fetch first doctor
        Doctor doctor = doctorRepository.findById(1L).orElse(null);

        if (doctor != null) {
            // Get appointments for this doctor
            List<Appointment> appointments = appointmentRepository.findByDoctorId(doctor.getId());
            model.addAttribute("appointments", appointments);
            model.addAttribute("doctorName", doctor.getName());
        }

        return "doctor-dashboard";  // Thymeleaf page
    }



    // URL pattern includes userId
    @GetMapping("/{userId}/availability")
    public ResponseEntity<List<LocalTime>> getDoctorAvailability(
            @PathVariable Long userId,
            @RequestHeader("Authorization") String token,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        // Validate token using TokenService
        if (!tokenService.validateToken(token, userId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<LocalTime> availableTimes = doctorService.getAvailability(userId, date);
        return ResponseEntity.ok(availableTimes);
    }
}

