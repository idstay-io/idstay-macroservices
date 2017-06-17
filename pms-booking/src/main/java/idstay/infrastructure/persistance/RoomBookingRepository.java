package idstay.infrastructure.persistance;




import idstay.domain.model.RoomBooking;
import idstay.domain.model.RoomBookingID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by min on 4/11/17.
 */
public interface RoomBookingRepository extends JpaRepository<RoomBooking, RoomBookingID> {
    @Query("SELECT r FROM RoomBooking r")
    List<RoomBooking> findBookingRooms();
}
