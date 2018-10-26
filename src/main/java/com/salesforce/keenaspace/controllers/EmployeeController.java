package com.salesforce.keenaspace.controllers;

import com.salesforce.keenaspace.VOs.EmployeeVO;
import com.salesforce.keenaspace.entity.Employee;
import com.salesforce.keenaspace.services.EmployeeService;
import com.salesforce.keenaspace.util.RestCaller;
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
  public EmployeeVO getKeenaEmployeeDetails() throws Exception {
    String email = "sneema@salesforce.com";
    Employee employee = employeeService.findByEmail(email);
    EmployeeVO employeeVO = new EmployeeVO();
    employeeVO.setEmployeeId(employee.getId());
    employeeVO.setEmail(email);
    employeeVO.setFirstname(employee.getFirstname());
    employeeVO.setLastname(employee.getLastname());
    employeeVO.setManagerId(employee.getManager().getId());
    return employeeVO;
        }

    @RequestMapping(value = "/getTeamMembers", method = RequestMethod.GET)
    public List<Employee> getKeenaTeamMembers(@RequestParam("managerId") int managerId) {
        return employeeService.findAllByManagerId(managerId);
    }

}
