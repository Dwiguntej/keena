package com.salesforce.keenaspace.repository;

import com.salesforce.keenaspace.entity.Employee;
import com.salesforce.keenaspace.entity.Seat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SeatRepository extends CrudRepository<Seat,String> {
    @Query(nativeQuery = true,
            value = "Select id from Seat where employee_id in (:employees)")
    List<String> getAvailableSeats(@Param("employees")List<Integer> employees);

    List<Seat> findAllByEmployee_IdIn(List<Integer>employees);

    @Query(nativeQuery = true,
            value = "Select * from Seat where id in (:seatId)")
    Seat findSeatById(@Param("seatId")String seatId);
}
