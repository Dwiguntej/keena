package com.salesforce.keenaspace.services.impl;

import com.salesforce.keenaspace.VOs.LeaveVO;
import com.salesforce.keenaspace.entity.Leave;
import com.salesforce.keenaspace.entity.Seat;
import com.salesforce.keenaspace.entity.SeatReservation;
import com.salesforce.keenaspace.repository.EmployeeRepository;
import com.salesforce.keenaspace.repository.LeaveRepository;
import com.salesforce.keenaspace.repository.SeatRepository;
import com.salesforce.keenaspace.repository.SeatReservationRepository;
import com.salesforce.keenaspace.services.LeaveService;
import com.salesforce.keenaspace.util.KeenaUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
   private LeaveRepository leaveRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private SeatReservationRepository seatReservationRepository;

    @Override
    public Leave applyLeave(LeaveVO leaveDetails) {
        Leave leave = new Leave();
        leave.setEmployeeOnLeave(employeeRepository.findById(leaveDetails.getEmpId()));
        leave.setAppliedBy(employeeRepository.findById(leaveDetails.getAppliedBy()));
        leave.setStartDate(KeenaUtility.getDateWithoutTime(leaveDetails.getStartDate()));
        leave.setEndDate(KeenaUtility.getDateWithoutTime(leaveDetails.getEndDate()));
        leave = leaveRepository.save(leave);

        Date startDate = leaveDetails.getStartDate();
        Date endDate = leaveDetails.getEndDate();
        while(startDate.compareTo(endDate)>=0)
        {
           List employeeIdsOnLeave = leaveRepository.getDistinctTeamLeaves(employeeRepository.findById(leaveDetails.getEmpId()).getManager().getId(),startDate);
           double totalEmployees = employeeRepository.findAllByManager_Id(employeeRepository.findById(leaveDetails.getEmpId()).getManager().getId()).size();

          //logic to check if there are seats which can be made free for the particular day
          if(totalEmployees*(0.8d)> (totalEmployees - employeeIdsOnLeave.size())) {
              List<String> availableSeatIds = seatRepository.getAvailableSeats(employeeIdsOnLeave);
              int  noOfSeatsToBeMadeAvailable = (int) (employeeIdsOnLeave.size() - (totalEmployees - (totalEmployees*0.8)));
              if(noOfSeatsToBeMadeAvailable==1){
                  SeatReservation seatReservation = new SeatReservation();
                  seatReservation.setSeat(seatRepository.findSeatById(availableSeatIds.get(0)));
                  seatReservation.setDateAvailable(KeenaUtility.getDateWithoutTime(startDate));
                  seatReservationRepository.save(seatReservation);
              }
              else if(noOfSeatsToBeMadeAvailable>1) {
                List<String> reservedSeats = seatReservationRepository.reservedSeatIds(availableSeatIds);
                reservedSeats.removeAll(availableSeatIds);
                  SeatReservation seatReservation = new SeatReservation();
                  seatReservation.setSeat(seatRepository.findSeatById(reservedSeats.get(0)));
                  seatReservation.setDateAvailable(KeenaUtility.getDateWithoutTime(startDate));
                  seatReservationRepository.save(seatReservation);
              }
          }
            startDate = addDays(startDate,1);
        }
       return leave;
    }
    public static Date addDays(Date date, int days) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
}
