package com.salesforce.keenaspace.services.impl;

import com.salesforce.keenaspace.entity.SeatReservation;
import com.salesforce.keenaspace.repository.EmployeeRepository;
import com.salesforce.keenaspace.repository.SeatRepository;
import com.salesforce.keenaspace.repository.SeatReservationRepository;
import com.salesforce.keenaspace.services.SeatReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SeatReservationServiceImpl implements SeatReservationService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatReservationRepository seatReservationRepository;


    @Override
    public List<SeatReservation> findAllAvailableSeats(String location, String floor) {
        return seatReservationRepository.findAllByDateAvailableEqualsAndSeat_LocationEqualsAndSeat_FloorAndReservedForIsNull(new Date(), location, floor);
    }

    @Override
    public boolean reserveSeat(int empId, String seatId) {
        SeatReservation seatReservation = seatReservationRepository.findBySeat_IdAnAndDateAvailable(seatId, new Date());
        if (seatReservation.getReservedFor() != null) {
            throw new DataIntegrityViolationException("This Seat booking is in progress, please choose some other ");
        }
        seatReservation.setReservedFor(employeeRepository.findByEmpId(empId));
        seatReservationRepository.save(seatReservation);
        return true;
//        SeatReservation sr = new SeatReservation();
//        sr.setSeat(seatRepository.findBySeatId(seatId));
//        sr.setReservedFor(employeeRepository.findByEmpId(empId));
//        try{
//            SeatReservationRepository.save(sr);
//        }catch (Exception ex) {
//           ex.printStackTrace();
//           return false;
//        }
//        return true;
    }

    @Override
    public boolean unReserveSeat(int empId, String seatId) {
        return true;
    }
}
