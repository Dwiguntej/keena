package com.salesforce.keenaspace.entity;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

  @Column(name = "EMPLOYEE_ID")
  @Id
  private int id;

  @Column(name = "FIRST_NAME")
  private String firstname;

  @Column(name = "LAST_NAME")
  private String lastname;

  @JoinColumn(name = "MANAGER_ID")
  @OneToOne(fetch = FetchType.LAZY)
  private Employee manager;

  @Column(name = "EMAIL")
  private String email;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Employee getManager() {
    return manager;
  }

  public void setManager(Employee manager) {
    this.manager = manager;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
