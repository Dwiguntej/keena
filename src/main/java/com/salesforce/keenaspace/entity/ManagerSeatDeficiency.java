package com.salesforce.keenaspace.entity;

import javax.persistence.*;

@Entity
@Table(name = "MANAGER_SEAT_DEFICIENCY")
public class ManagerSeatDeficiency {

  @Id private int id;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "MANAGER_ID")
  private Employee manager;

  @Column(name = "SEAT_DEFICIENCY")
  private int seatDeficiency;

  public Employee getManager() {
    return manager;
  }

  public void setManager(Employee manager) {
    this.manager = manager;
  }

  public int getSeatDeficiency() {
    return seatDeficiency;
  }

  public void setSeatDeficiency(int seatDeficiency) {
    this.seatDeficiency = seatDeficiency;
  }
}
