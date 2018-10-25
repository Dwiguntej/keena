package com.salesforce.keenaspace.services.impl;

import com.salesforce.keenaspace.entity.SeatReservation;
import com.salesforce.keenaspace.repository.SeatReservationRepository;
import com.salesforce.keenaspace.services.SeatReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SeatReservationServiceImpl implements SeatReservationService {

  @Autowired private SeatReservationRepository seatReservationRepository;

  @Override
  public boolean reserveSeat(int empId, String seatId) {
    return true;
  }

  @Override
  public boolean unReserveSeat(int empId, String seatId) {
    return true;
  }

  @Override
  public List<SeatReservation> findAllAvailableSeats(String location, String floor) {
    return seatReservationRepository.findAllByDateAvailableEqualsAndSeat_LocationEqualsAndSeat_FloorAndReservedForIsNull(new Date(), location, floor);
  }
}
