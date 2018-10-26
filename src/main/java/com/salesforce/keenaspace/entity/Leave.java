package com.salesforce.keenaspace.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LEAVE")
public class Leave {

    @Id @GeneratedValue private int id;

    @OneToOne
    @JoinColumn(name = "EMPLOYEE_ON_LEAVE")
    private Employee employeeOnLeave;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @OneToOne
    @JoinColumn(name = "APPPLIED_BY")
    private Employee appliedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployeeOnLeave() {
        return employeeOnLeave;
    }

    public void setEmployeeOnLeave(Employee employeeOnLeave) {
        this.employeeOnLeave = employeeOnLeave;
    }


    public Employee getAppliedBy() {
        return appliedBy;
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

    public void setAppliedBy(Employee appliedBy) {
        this.appliedBy = appliedBy;
    }
}
