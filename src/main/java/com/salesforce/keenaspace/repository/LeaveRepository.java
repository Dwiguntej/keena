package com.salesforce.keenaspace.repository;

import com.salesforce.keenaspace.VOs.LeaveVO;
import com.salesforce.keenaspace.entity.Leave;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LeaveRepository extends CrudRepository<Leave,Integer> {

    @Query(nativeQuery = true,
            value = "Select distinct(EMPLOYEE_ON_LEAVE) from leave l,employee e where e.employee_id = l.EMPLOYEE_ON_LEAVE and e.manager_id = :managerId and :dateVar between l.start_date and l.end_date")
    List<Integer> getDistinctTeamLeaves(@Param("managerId")int managerId, @Param("dateVar") Date dateVar);
}
