package com.salesforce.keenaspace.services;

import com.salesforce.keenaspace.entity.Employee;
import org.springframework.stereotype.Service;

public interface EmployeeService {
    Employee findByEmail(String email);
}
