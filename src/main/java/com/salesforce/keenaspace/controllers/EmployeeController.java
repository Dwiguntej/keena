package com.salesforce.keenaspace.controllers;

import com.salesforce.keenaspace.entity.Employee;
import com.salesforce.keenaspace.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/getEmployeeDetails", method = RequestMethod.GET)
    public Employee getKeenaEmployeeDetails(@RequestParam("emailId") String email) {
        return employeeService.findByEmail(email);
    }

    @RequestMapping(value = "/getTeamMembers", method = RequestMethod.GET)
    public List<Employee> getKeenaTeamMembers(@RequestParam("managerId") int managerId) {
        return employeeService.findAllByManagerId(managerId);
    }

}
