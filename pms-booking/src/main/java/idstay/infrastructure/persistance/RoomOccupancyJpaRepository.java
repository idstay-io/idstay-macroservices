package idstay.infrastructure.persistance;

import idstay.domain.model.RoomBooking;
import idstay.domain.model.RoomOccupancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by min on 6/4/17.
 */
public interface RoomOccupancyJpaRepository extends JpaRepository<RoomOccupancy, Long> {
    @Query("SELECT b FROM RoomOccupancy b WHERE b.hotelId= ?1 AND b.roomId = ?2 AND b.date BETWEEN ?3 AND ?4")
    List<RoomOccupancy> findByDatesBetween(Long hotelId, Long roomId, String departure, String arrival);

}
