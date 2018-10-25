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

  @Column(name = "DATE_OF_LEAVE")
  private Date dateOfLeave;

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

  public Date getDateOfLeave() {
    return dateOfLeave;
  }

  public void setDateOfLeave(Date dateOfLeave) {
    this.dateOfLeave = dateOfLeave;
  }

  public Employee getAppliedBy() {
    return appliedBy;
  }

  public void setAppliedBy(Employee appliedBy) {
    this.appliedBy = appliedBy;
  }
}
