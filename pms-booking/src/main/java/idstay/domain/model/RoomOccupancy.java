package idstay.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROOM_OCCUPANCY")
public class RoomOccupancy {
    @Id
    @GeneratedValue
    private Long id;

    private Long hotelId;
    private Long roomId;
    private String date;
    private String stayType;

    public RoomOccupancy(Long hotelId, Long roomId, String date, String stayType) {
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.date = date;
        this.stayType = stayType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStayType() {
        return stayType;
    }

    public void setStayType(String stayType) {
        this.stayType = stayType;
    }

    @Override
    public String toString() {
        return "RoomOccupancy{" +
                "id=" + id +
                ", roomId=" + roomId +
                ", date='" + date + '\'' +
                ", stayType='" + stayType + '\'' +
                '}';
    }

    RoomOccupancy() {}

}
