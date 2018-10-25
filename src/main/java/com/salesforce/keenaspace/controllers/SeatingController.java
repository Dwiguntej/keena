package com.salesforce.keenaspace.controllers;

import com.salesforce.keenaspace.entity.Seat;
import com.salesforce.keenaspace.entity.SeatReservation;
import com.salesforce.keenaspace.services.SeatReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class SeatingController {

    Logger LOG = LoggerFactory.getLogger(SeatingController.class);

    @Autowired
    SeatReservationService seatReservationService;

    @RequestMapping("/welcome")
    public String getWelcome(){
        return "welcome";
    }

    @RequestMapping("/")
    public String getHello(HttpServletRequest request) {
        Map<String, String[]> parameters = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
            LOG.error("Params: Key:" + entry.getKey() + "-----Params:values:" + entry.getValue());
        }
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
