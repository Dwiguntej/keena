package com.salesforce.keenaspace.services;

import com.salesforce.keenaspace.entity.Seat;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SeatReservationService {
    public List<Seat> findAllAvailableSeats();
}