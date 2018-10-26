package com.salesforce.keenaspace.repository;

import com.salesforce.keenaspace.entity.SeatReservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SeatReservationRepository extends CrudRepository<SeatReservation, Integer> {

    List<SeatReservation> findAllByDateAvailableEqualsAndSeat_LocationEqualsAndSeat_FloorAndReservedForIsNull(Date dataAvailable, String location, String floor);

    SeatReservation findBySeat_IdAndDateAvailable(String seatId, Date date);

    SeatReservation findSeatReservationByIdEquals(int empId);

    SeatReservation findBySeat_IdAndReservedFor_Id(String seatId, int empId);

    @Query(nativeQuery = true, value = "select SEAT_ID from SEAT_RESERVATION where SEAT_ID in (:seatIds)")
    List<String> reservedSeatIds(@Param("seatIds") List<String> seatIds);
}
