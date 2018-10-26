package com.salesforce.keenaspace.VOs;

public class SeatVO {

    private String seatid;
    private String managername;

    public SeatVO(String seatid, String managername) {
        this.seatid = seatid;
        this.managername = managername;
    }

    public String getSeatid() {
        return seatid;
    }

    public void setSeatid(String seatid) {
        this.seatid = seatid;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }
}
