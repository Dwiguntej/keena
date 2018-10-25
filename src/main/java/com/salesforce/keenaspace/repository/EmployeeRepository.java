package com.salesforce.keenaspace.repository;

import com.salesforce.keenaspace.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findAllByManager_Id(int managerId);
}
