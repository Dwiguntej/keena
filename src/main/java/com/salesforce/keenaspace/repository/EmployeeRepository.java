package com.salesforce.keenaspace.repository;

import com.salesforce.keenaspace.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findAllByManager_Id(int managerId);

    Employee findByEmail(String email);
}
