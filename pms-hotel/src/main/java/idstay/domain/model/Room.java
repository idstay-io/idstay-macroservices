package idstay.domain.model;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by min on 3/20/17.
 */

@Entity
@Table(name="ROOM")
@Getter @ToString
public class Room {

    @Id
    private RoomCode code;

    private HotelId hotelId;

    @Column(name="ROOM_NAME")
    private String roomNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ROOM_TYPE_CODE")
    private RoomType roomType;

    private int floor;


    public Room(final RoomCode code, final String roomNumber, final HotelId hotelId, final RoomType roomType, final int floor) {
        this.code = code;
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.floor = floor;
    }

    Room() {}
}
