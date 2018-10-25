package com.salesforce.keenaspace.entity;

import com.salesforce.keenaspace.entity.Employee;

import javax.persistence.*;

@Entity
@Table(name = "SEAT")
public class Seat {

  @Id private String id;

  @Column(name = "LOCATION")
  private String location;

  @Column(name = "FLOOR")
  private String floor;

  @JoinColumn(name = "EMPLOYEE_ID")
  @OneToOne(fetch = FetchType.LAZY)
  private Employee employee;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getFloor() {
    return floor;
  }

  public void setFloor(String floor) {
    this.floor = floor;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
}
