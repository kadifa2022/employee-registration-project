package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Employee;
import com.cydeo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;//injection class

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/register")
    public String createEmployee(Model model){

        model.addAttribute("employee", new Employee());
        model.addAttribute("stateList", DataGenerator.getAllStates());

        return "employee/employee-create";

    }
    @PostMapping("/insert")//because of business logic we separate (data that cary data)-re//direct ot another method and used//solid principle -only one reason to change logic
    public String insertEmployee(@ModelAttribute("employee")@Valid Employee employee, BindingResult bindingResult, Model model){//for @Valid we have to use BindingResult together
        if(bindingResult.hasErrors()){
            model.addAttribute("stateList", DataGenerator.getAllStates());
            return "employee/employee-create";

        }
        employeeService.saveEmployee(employee);

        return "redirect:/employee/list";//with re:direct we are using end points

    }
    @GetMapping("/list")
    public String listEmployees(Model model){
        model.addAttribute("employeeList", employeeService.readAllEmployees());
        return "employee/employee-list";//without re:direct we are using html file
    }



}
