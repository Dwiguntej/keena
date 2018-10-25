package com.salesforce.keenaspace.services.impl;

import com.salesforce.keenaspace.VOs.LeaveVO;
import com.salesforce.keenaspace.entity.Leave;
import com.salesforce.keenaspace.repository.EmployeeRepository;
import com.salesforce.keenaspace.repository.LeaveRepository;
import com.salesforce.keenaspace.services.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
   private LeaveRepository leaveRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Leave applyLeave(LeaveVO leaveDetails) {
        Leave leave = new Leave();
        leave.setEmployeeOnLeave(employeeRepository.findByEmpId(leaveDetails.getEmpId()));
        leave.setAppliedBy(employeeRepository.findByEmpId(leaveDetails.getAppliedBy()));
        leave.setStartDate(leaveDetails.getStartDate());
        leave.setEndDate(leaveDetails.getEndDate());
       return leaveRepository.save(leave);
    }
}
