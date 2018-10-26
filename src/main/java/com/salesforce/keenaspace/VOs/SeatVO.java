package com.salesforce.keenaspace.VOs;

public class SeatVO {

    private String seatId;
    private String managerName;
    private String empId;

    public SeatVO(String seatId, String managerName,String empId) {
        this.seatId = seatId;
        this.managerName = managerName;
        this.empId = empId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
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
