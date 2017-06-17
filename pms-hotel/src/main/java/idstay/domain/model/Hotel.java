package idstay.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="HOTEL")
public class Hotel {
    @Id
    private HotelId hotelId;

    @Column(name="HOTEL_NAME")
    private String hotelName;

    @OneToMany
    @JoinColumn(name="HOTEL_ID")
    private List<RoomType> roomTypes = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="HOTEL_ID")
    private List<Room> rooms = new ArrayList<>();

    public Hotel(final HotelId hotelId, final String hotelName) {

        setHotelId(hotelId);
        setHotelName(hotelName);
    }

    private void setHotelId(HotelId hotelId) {
        this.hotelId = hotelId;
    }

    private void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Hotel withRoomType(final RoomType roomType) {
        roomTypes.add(roomType);
        return this;
    }

    public void setRoomTypes(List<RoomType> roomTypes) {
       // verifyAtLeastOneOrMoreRoomTypes(roomTypes);

    }

    private void verifyAtLeastOneOrMoreRoomTypes(List<RoomType> roomTypes) {
        if (roomTypes == null || roomTypes.isEmpty()) {
            throw new IllegalArgumentException("no roomTypes");
        }
    }

    public void with(final List<Room> rooms) {
        verifyAtLeastOneOrMoreRooms(rooms);
        this.rooms = rooms;
    }

    private void verifyAtLeastOneOrMoreRooms(List<Room> rooms) {
        if (rooms == null || rooms.isEmpty()) {
            throw new IllegalArgumentException("no rooms");
        }
    }


    public HotelId getHotelId() {
        return hotelId;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", roomTypes=" + roomTypes +
                ", rooms=" + rooms +
                '}';
    }

    public void withRoomTypes(final List<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public String getHotelName() {
        return hotelName;
    }
    public List<RoomType> getRoomTypes() {
        return roomTypes;
    }
    public List<Room> getRooms() {
        return rooms;
    }

    Hotel(){
        //Needed by JPA
    }
}

