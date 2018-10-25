package com.salesforce.keenaspace.controllers;

import com.salesforce.keenaspace.entity.Seat;
import com.salesforce.keenaspace.services.SeatReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SeatingController {

    @Autowired
    SeatReservationService seatReservationService;

    @RequestMapping("/welcome")
    public String getWelcome(){
        return "welcome";
    }

    @RequestMapping("/")
    public String getHello(){
        return "hello";
    }

    @ResponseBody
    @GetMapping("/availableSeats")
    public List<Seat>getListofSeats(){
        return seatReservationService.findAllAvailableSeats();
    }

    @ResponseBody
    @GetMapping("/reserveSeat")
    public boolean reserveSeat(@RequestParam(value="empId") int empId, @RequestParam(value="seatId") String seatId) {
        return seatReservationService.reserveSeat(empId,seatId);
    }
}
