package idstay.infrastructure.persistance;

import idstay.domain.model.HotelId;
import idstay.domain.model.RoomType;
import idstay.domain.model.RoomTypeCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by min on 6/4/17.
 */
public interface RoomTypeRepository extends JpaRepository<RoomType, RoomTypeCode> {
    List<RoomType> findByHotelId(HotelId hotelId);
}
