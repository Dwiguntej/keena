package com.salesforce.keenaspace.entity;

import com.salesforce.keenaspace.entity.Employee;

import java.util.Date;

public class Leave {
    private Employee employeeOnLeave;
    private Employee appliedBy;
    private Date startDate;
    private Date endDate;

    public void setEmployeeOnLeave(Employee employeeOnLeave) {
        this.employeeOnLeave = employeeOnLeave;
    }

    public Employee getEmployeeOnLeave() {
        return employeeOnLeave;
    }

    public void setAppliedBy(Employee appliedBy) {
        this.appliedBy = appliedBy;
    }

    public Employee getAppliedBy() {
        return appliedBy;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
