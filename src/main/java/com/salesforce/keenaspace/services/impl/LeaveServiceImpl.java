package com.salesforce.keenaspace.services.impl;

import com.salesforce.keenaspace.entity.Leave;
import com.salesforce.keenaspace.repository.LeaveRepository;
import com.salesforce.keenaspace.services.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
   private LeaveRepository leaveRepository;

    @Override
    public Leave applyLeave(Leave leaveDetails) {
       return leaveRepository.save(leaveDetails);
    }
}
