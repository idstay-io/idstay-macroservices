package idstay.application;

import idstay.domain.model.HotelId;
import idstay.domain.model.Room;
import idstay.domain.model.RoomType;

import java.util.List;

public interface HotelPropertyService {
    List<Room> getAllRooms(HotelId hotelId);
    List<RoomType> getAllRoomTypes(HotelId hotelId);
}
