package com.salesforce.keenaspace.services;

import com.salesforce.keenaspace.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    Employee findByEmail(String email);

    List<Employee> findAllByManagerId(int managerId);
}
