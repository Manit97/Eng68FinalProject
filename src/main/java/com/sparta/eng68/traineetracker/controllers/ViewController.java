package com.sparta.eng68.traineetracker.controllers;

import com.sparta.eng68.traineetracker.utilities.Pages;
import com.sparta.eng68.traineetracker.utilities.Roles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.management.relation.Role;

@Controller
public class ViewController {

    @GetMapping("/consultancy")
    public String getConsultancySkills() {
        return Pages.accessPage(Roles.ANY, Pages.CONSULTANCY);
    }
}
