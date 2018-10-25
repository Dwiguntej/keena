package com.salesforce.keenaspace.services.impl;

import com.salesforce.keenaspace.entity.Employee;
import com.salesforce.keenaspace.repository.EmployeeRepository;
import com.salesforce.keenaspace.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);

    }

    @Override
    public List<Employee> findAllByManagerId(int managerId) {
        return employeeRepository.findAllByManager_Id(managerId);
    }
}
