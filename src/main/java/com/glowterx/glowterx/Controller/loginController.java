package com.glowterx.glowterx.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glowterx.glowterx.DOA.AdminDOA;
import com.glowterx.glowterx.DOA.InstructorDOA;
import com.glowterx.glowterx.DOA.TraineeDOA;
import com.glowterx.glowterx.Model.Admin;
import com.glowterx.glowterx.Model.Instructor;
import com.glowterx.glowterx.Model.Trainee;

@Controller
public class loginController {
    @Autowired
    private AdminDOA adminDAO;

    @Autowired
    private InstructorDOA instructorDAO;

    @Autowired
    private TraineeDOA traineeDAO;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password,
            Model model) {
        Admin admin = adminDAO.validate(username, password);
        if (admin != null) {
            model.addAttribute("username", admin.getUsername());
            return "Admin/ProfileInAdmin";
        }
        Instructor instructor = instructorDAO.validate(username, password);
        if (instructor != null) {
            model.addAttribute("username", instructor.getUsername());
            return "instructor_welcome";
        }
        Trainee trainee = traineeDAO.validate(username, password);
        if (trainee != null) {
            model.addAttribute("username", trainee.getUsername());
            return "trainee_welcome";
        } else {
            model.addAttribute("errorMessage", "Invalid credentials");
            return "login";
        }
    }
}
