package com.salesforce.keenaspace.VOs;

import java.util.Date;

public class LeaveVO {
    private int empId;
    private int appliedBy;
    private Date startDate;
    private Date endDate;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getAppliedBy() {
        return appliedBy;
    }

    public void setAppliedBy(int appliedBy) {
        this.appliedBy = appliedBy;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
