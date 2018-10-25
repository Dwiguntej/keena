package com.salesforce.keenaspace.repository;

import com.salesforce.keenaspace.entity.SeatReservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatReservationRepository extends CrudRepository<SeatReservation, Integer> {

    List<SeatReservation> findAllByReservedForIsNull();
}
