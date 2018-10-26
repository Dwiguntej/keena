package com.salesforce.keenaspace.services.impl;

import com.salesforce.keenaspace.DAO.SeatReservationDAO;
import com.salesforce.keenaspace.VOs.SeatVO;
import com.salesforce.keenaspace.entity.SeatReservation;
import com.salesforce.keenaspace.repository.EmployeeRepository;
import com.salesforce.keenaspace.repository.SeatReservationRepository;
import com.salesforce.keenaspace.services.SeatReservationService;
import com.salesforce.keenaspace.util.KeenaUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SeatReservationServiceImpl implements SeatReservationService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SeatReservationRepository seatReservationRepository;

    @Autowired
    private SeatReservationDAO seatReservationDAO;


    @Override
    public List<SeatVO> findAllAvailableSeats(String location, String floor) {
        return seatReservationDAO.findAvailableSeats();
    }

    @Override
    public boolean reserveSeat(int empId, String seatId) {
        SimpleDateFormat estFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            SeatReservation seatReservation = seatReservationRepository.findBySeat_IdAndDateAvailable(seatId, KeenaUtility.getDateInUTCTimezone(estFormatter.parse(estFormatter.format(new Date()))));

            if (seatReservation != null && seatReservation.getReservedFor() != null) {
                throw new DataIntegrityViolationException("This Seat booking is in progress, please choose some other Seat ");
            }
            if (seatReservation != null) {
                seatReservation.setReservedFor(employeeRepository.findById(empId));
                seatReservationRepository.save(seatReservation);
                return true;
            }
        } catch (Exception ex) {

        }
        return false;
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
        SeatReservation seatReservation = seatReservationRepository.findBySeat_IdAndReservedFor_Id(seatId, empId);
        seatReservation.setReservedFor(null);
        seatReservationRepository.save(seatReservation);
        return true;
    }

    @Override
    public SeatReservation getReservedSeat(int empid) {
        return seatReservationRepository.findSeatReservationByIdEquals(empid);
    }


}
