package idstay.application.support;

import idstay.application.HotelProperty;
import idstay.application.HotelPropertyService;
import idstay.domain.model.HotelId;
import idstay.domain.model.Room;
import idstay.domain.model.RoomType;
import idstay.infrastructure.persistance.RoomRepository;
import idstay.infrastructure.persistance.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by min on 6/5/17.
 */
@Component
public class HotelPropertyServiceDefault implements HotelPropertyService {
    private RoomRepository roomRepository;
    private RoomTypeRepository roomTypeRepository;


    @Override
    @Cacheable("rooms")
    public List<Room> getAllRooms(HotelId hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }

    @Override
    @Cacheable("roomTypes")
    public List<RoomType> getAllRoomTypes(HotelId hotelId) {
        return roomTypeRepository.findByHotelId(hotelId);
    }

    @Autowired
    public void setRoomRepository(final RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Autowired
    public void setRoomTypeRepository(final RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }
}
