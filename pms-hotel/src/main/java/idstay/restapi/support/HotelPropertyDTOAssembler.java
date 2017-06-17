package idstay.restapi.support;

import idstay.domain.model.Hotel;
import idstay.domain.model.Room;
import idstay.domain.model.RoomType;
import idstay.restapi.dto.HotelPropertyDTO;

import java.util.List;

/**
 * Created by min on 5/6/17.
 */
public class HotelPropertyDTOAssembler {
    private HotelPropertyDTO dto = new HotelPropertyDTO();

    public void setRooms(List<Room> rooms) {
        for(Room room : rooms) {
            dto.addRoom(new HotelPropertyDTO.Room(
                    room.getCode().codeString(),
                    room.getRoomNumber(),
                    room.getRoomType().getRoomTypeCode().codeString(),
                    room.getFloor()));
        }
    }

    public void setRoomTypes(List<RoomType> roomTypes) {
        for(RoomType roomType : roomTypes) {
            dto.addRoomType(new HotelPropertyDTO.RoomType(
                    roomType.getRoomTypeCode().codeString(),
                    roomType.getRoomTypeName()
            ));
        }

    }

    public HotelPropertyDTO getDto() {
        return dto;
    }

}
