package com.salesforce.keenaspace.repository;

import javax.persistence.*;

@Entity
@Table(name = "SEAT")
public class Seat {

    @Id
    private String id;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "FLOOR")
    private String floor;

    @JoinColumn(name ="EMPLOYEE_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Employee employee;




}
