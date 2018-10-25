package com.salesforce.keenaspace.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SEAT_RESERVATION")
public class SeatReservation {

  @Id private int id;

  @OneToOne
  @JoinColumn(name = "SEAT_ID")
  private Seat seat;

  @Column(name = "DATE_AVAILABLE")
  private Date dateAvailable;

  @JoinColumn(name = "EMPLOYEE_ID")
  @OneToOne
  private Employee reservedFor;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Seat getSeat() {
    return seat;
  }

  public void setSeat(Seat seat) {
    this.seat = seat;
  }

  public Date getDateAvailable() {
    return dateAvailable;
  }

  public void setDateAvailable(Date dateAvailable) {
    this.dateAvailable = dateAvailable;
  }

  public Employee getReservedFor() {
    return reservedFor;
  }

  public void setReservedFor(Employee reservedFor) {
    this.reservedFor = reservedFor;
  }
}
