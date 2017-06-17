package idstay.infrastructure.persistance;

import idstay.domain.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by min on 6/4/17.
 */
public interface RoomRepository extends JpaRepository<Room, RoomCode> {
    List<Room> findByHotelId(HotelId hotelId);
}

