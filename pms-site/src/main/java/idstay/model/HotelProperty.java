package idstay.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by min on 5/6/17.
 */
public class HotelProperty {
    private String hotelName;
    private List<RoomType> roomTypes = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();

    public String getHotelName() {
        return hotelName;
    }

    public HotelProperty setHotelName(String hotelName) {
        this.hotelName = hotelName;
        return this;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }




}
