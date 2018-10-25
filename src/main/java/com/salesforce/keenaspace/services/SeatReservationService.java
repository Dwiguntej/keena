package com.salesforce.keenaspace.services;

import com.salesforce.keenaspace.entity.SeatReservation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatReservationService {

   boolean reserveSeat(int empId, String seatId);

   boolean unReserveSeat(int empId, String seatId);

    List<SeatReservation> findAllAvailableSeats(String location, String floor);
}
