package com.salesforce.keenaspace.services;

import com.salesforce.keenaspace.VOs.LeaveVO;
import com.salesforce.keenaspace.entity.Leave;

public interface LeaveService {
    public Leave applyLeave(LeaveVO leaveDetails);
}
