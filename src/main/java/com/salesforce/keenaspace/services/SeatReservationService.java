package com.salesforce.keenaspace.services;

import com.salesforce.keenaspace.entity.Seat;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SeatReservationService {
    public List<Seat> findAllAvailableSeats();
    public boolean reserveSeat(int empId, String seatId);
    public boolean unReserveSeat(int empId, String seatId);
}
