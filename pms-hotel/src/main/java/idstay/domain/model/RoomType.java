package idstay.domain.model;



import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="ROOM_TYPE")
@Getter @ToString
public class RoomType {

    @Id
    private RoomTypeCode roomTypeCode;
    private HotelId hotelId;

    @Column(name = "ROOM_TYPE_NAME")
    private String roomTypeName;

    @Column(name = "ACRONYM")
    private String acronym;

    @Embedded
    private RoomTypeProfile profile = new RoomTypeProfile();


    public RoomType(final RoomTypeCode roomTypeCode, final HotelId hotelId, final String roomTypeName) {
        this.roomTypeCode = roomTypeCode;
        this.hotelId = hotelId;
        this.roomTypeName = roomTypeName;
    }

    public RoomType acronym(final String acronym) {
        this.acronym = acronym;
        return this;
    }

    public RoomType profile(final RoomTypeProfile profile) {
        this.profile = profile;
        return this;
    }

    RoomType() {}
}

