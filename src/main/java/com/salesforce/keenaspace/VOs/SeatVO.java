package com.salesforce.keenaspace.VOs;

public class SeatVO {

    private String seatId;
    private String managerName;
    private Integer employeeId;

    public SeatVO(String seatId, String managerName,Integer employeeId) {
        this.seatId = seatId;
        this.managerName = managerName;
        this.employeeId = employeeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
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
