package com.salesforce.keenaspace.controllers;

import com.salesforce.keenaspace.entity.Leave;
import com.salesforce.keenaspace.entity.Seat;
import com.salesforce.keenaspace.services.LeaveService;
import com.salesforce.keenaspace.services.SeatReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class LeaveController {

    @Autowired
    LeaveService leaveService;

    @ResponseBody
    @PostMapping("/applyLeave")
    public ResponseEntity< String > applyLeave(@RequestBody Leave leaveDetails){
        Leave leave = leaveService.applyLeave(leaveDetails);
        if(!ObjectUtils.isEmpty(leave)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
