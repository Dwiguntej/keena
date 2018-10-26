package com.salesforce.keenaspace.controllers;

import com.salesforce.keenaspace.entity.Seat;
import com.salesforce.keenaspace.entity.SeatReservation;
import com.salesforce.keenaspace.services.SeatReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String getHello(HttpServletRequest request) {
        return "hello";
    }

    @ResponseBody
    @GetMapping("/availableSeats")
    public List<Seat>getListofSeats(){
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/reserveSeat",method = RequestMethod.POST)
    public boolean reserveSeat(@RequestParam(value="empId") int empId, @RequestParam(value="seatId") String seatId) {
        return seatReservationService.reserveSeat(empId,seatId);
    }

    @ResponseBody
    @RequestMapping(value = "/unReserveSeat",method = RequestMethod.PUT)
    public boolean unReserveSeat(@RequestParam(value="empId") int empId, @RequestParam(value="seatId") String seatId) {
        return seatReservationService.unReserveSeat(empId,seatId);
    }

    @ResponseBody
    @RequestMapping(value = "/reservedSeat", method = RequestMethod.GET)
    public SeatReservation getResevedSeat(@RequestParam(value = "empId") int empId) {
        return seatReservationService.getReservedSeat(empId);
    }

}
