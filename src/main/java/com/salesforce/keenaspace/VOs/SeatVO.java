package com.salesforce.keenaspace.VOs;

public class SeatVO {

    private String seatId;
    private String managerName;

    public SeatVO(String seatId, String managerName) {
        this.seatId = seatId;
        this.managerName = managerName;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
