package idstay.restapi.dto;

import idstay.application.HotelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data @ToString
public class HotelPropertyDTO {
    private List<HotelPropertyDTO.RoomType> roomTypes = new ArrayList<>();
    private List<HotelPropertyDTO.Room> rooms = new ArrayList<>();

    public HotelPropertyDTO addRoomType(final HotelPropertyDTO.RoomType roomType) {
        roomTypes.add(roomType);
        return this;
    }

    public HotelPropertyDTO addRoom(final HotelPropertyDTO.Room room) {
        rooms.add(room);
        return this;
    }

    @Data @ToString
    public static class RoomType {
        private String roomTypeCode;
        private String roomTypeName;

        public RoomType(String roomTypeCode, String roomTypeName) {
            this.roomTypeCode = roomTypeCode;
            this.roomTypeName = roomTypeName;
        }
    }

    @Data @ToString
    public static class Room {
        private String roomCode;
        private String roomNumber;
        private String roomTypeCode;
        private int floor;

        public Room(String roomCode, String roomNumber, String roomTypeCode, int floor) {
            this.roomCode = roomCode;
            this.roomNumber = roomNumber;
            this.roomTypeCode = roomTypeCode;
            this.floor = floor;
        }
    }
}
