package com.salesforce.keenaspace.services.impl;

import com.salesforce.keenaspace.entity.Seat;
import com.salesforce.keenaspace.services.SeatReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatReservationServiceImpl implements SeatReservationService {
    @Override
    public List<Seat> findAllAvailableSeats() {
        return null;
    }

    @Override
    public boolean reserveSeat(int empId, String seatId){
        return true;
    }
}
