package com.salesforce.keenaspace.DAO;

import com.salesforce.keenaspace.VOs.SeatVO;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Component
public class SeatReservationDAO {
    @PersistenceContext
    private EntityManager em;

    public List<SeatVO> findAvailableSeats() {
        Query query = em.createNativeQuery(  "SELECT st.id AS seatId,manager.first_name AS managerName,sr.employee_id as employeeId FROM SEAT_RESERVATION sr, SEAT st, EMPLOYEE e, Employee manager WHERE sr.SEAT_ID = st.id AND st.EMPLOYEE_ID = e.employee_id AND e.manager_id = manager.employee_id");
        List<Object[]> rows = query.getResultList();
        List<SeatVO> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            result.add(new SeatVO((String) row[0],
                    (String) row[1],
                    (String) row[2]));
        }
        return result;
    }
}
