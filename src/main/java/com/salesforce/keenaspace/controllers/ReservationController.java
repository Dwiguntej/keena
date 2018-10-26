package com.salesforce.keenaspace.controllers;

import com.salesforce.keenaspace.VOs.SeatVO;
import com.salesforce.keenaspace.entity.SeatReservation;
import com.salesforce.keenaspace.services.SeatReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private SeatReservationService seatReservationService;

    @RequestMapping("/seats")
    public List<SeatVO> getAvailableSeats(@RequestParam("location") String location, @RequestParam("floor") String floor){
        return seatReservationService.findAllAvailableSeats(location, floor);
    }
}
