package com.svats.projets.ats.services.spring.controller;

import com.svats.projets.ats.services.entity.Employee;
import com.svats.projets.ats.services.spring.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee/")
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService service;

    public EmployeeController(final EmployeeService service) {
        this.service = service;
    }

    @GetMapping("signup")
    public String showSignUpForm(Employee employee) {
        return "add-employee";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        logger.debug("showUpdateForm");
        model.addAttribute("employees", service.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addEmployee(@Valid Employee employee, BindingResult result, Model model) {
        logger.debug("addEmployee");
        if (result.hasErrors()) {
            return "add-employee";
        }

        service.save(employee);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        logger.debug("showUpdateForm");
        Employee employee = service.findById(id);
        model.addAttribute("employee", employee);
        return "update-employee";
    }

    @PostMapping("update/{id}")
    public String updateEmployee(@PathVariable("id") long id, @Valid Employee employee,
                                 BindingResult result, Model model) {
        logger.debug("updateEmployee");
        if (result.hasErrors()) {
            employee.setId(id);
            return "update-employee";
        }

        service.save(employee);
        model.addAttribute("employees", service.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteEmployee(@PathVariable("id") long id, Model model) {
        logger.debug("deleteEmployee");
        service.delete(id);
        model.addAttribute("employees", service.findAll());
        return "index";
    }
}
