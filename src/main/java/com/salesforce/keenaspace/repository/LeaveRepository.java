package com.salesforce.keenaspace.repository;

import com.salesforce.keenaspace.entity.Leave;
import com.salesforce.keenaspace.entity.SeatReservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends CrudRepository<Leave,Integer> {
}
