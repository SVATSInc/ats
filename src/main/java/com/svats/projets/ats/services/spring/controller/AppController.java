package com.svats.projets.ats.services.spring.controller;

import com.svats.projets.ats.services.spring.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    Logger logger = LoggerFactory.getLogger(AppController.class);

    private final EmployeeService service;

    public AppController(final EmployeeService service) {
        this.service = service;
    }

    @GetMapping(value = {"/", "/home", "/index"})
    public String appRoot(Model model) {
        logger.debug("appRoot");
        model.addAttribute("employees", service.findAll());
        return "index";
    }
}
