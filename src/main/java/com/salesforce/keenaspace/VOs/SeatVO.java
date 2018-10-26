package com.salesforce.keenaspace.VOs;

public class SeatVO {

    private String seatId;
    private String managerName;
    private String employeeId;

    public SeatVO(String seatId, String managerName,String employeeId) {
        this.seatId = seatId;
        this.managerName = managerName;
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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
