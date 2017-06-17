package idstay.domain.model;


import org.apache.commons.lang3.Validate;

import javax.persistence.*;

@Entity
@Table(name="ROOM_BOOKING")
public class RoomBooking {
    @Id
    private RoomBookingID roomBookingID;

    @GeneratedValue
    private Long surid;

    private Long hotelID;

    private Long roomCode;

    @Embedded
    private Stay stay;

    @Embedded
    private Traveler traveler;

    @Enumerated(EnumType.STRING)
    private RoomBookingStatus status;

    public RoomBooking(final RoomBookingID roomBookingID,
                       final Long hotelID,
                       final Long roomCode,
                       final Stay stay,
                       final Traveler traveler,
                       final RoomBookingStatus status) {
        Validate.notNull(roomBookingID, "ID is required");
        Validate.notNull(hotelID, "hotel ID is required");
        Validate.notNull(roomCode, "Room Code is required");
        Validate.notNull(stay, "Stay Allocation is required");
        Validate.notNull(traveler, "Traveler is required");
        Validate.notNull(status, "Status is required");

        this.roomBookingID = roomBookingID;
        this.hotelID = hotelID;
        this.roomCode = roomCode;
        this.stay = stay;
        this.traveler = traveler;
        this.status = status;
    }

    public RoomBookingID id() {
        return roomBookingID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomBooking that = (RoomBooking) o;

        return roomBookingID != null ? roomBookingID.equals(that.roomBookingID) : that.roomBookingID == null;
    }

    @Override
    public int hashCode() {
        return roomBookingID != null ? roomBookingID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "RoomBooking{" +
                "roomBookingID=" + roomBookingID +
                ", surid=" + surid +
                ", hotelID=" + hotelID +
                ", roomCode=" + roomCode +
                ", stay=" + stay +
                ", traveler=" + traveler +
                ", status=" + status +
                '}';
    }

    public void checkin() {
        if (status == RoomBookingStatus.RESERVED || status == RoomBookingStatus.NOSHOW)
            status = RoomBookingStatus.CHECKED_IN;
    }


    public void checkout() {
        if (status == RoomBookingStatus.CHECKED_IN)
            status = RoomBookingStatus.CHECKED_OUT;
    }
    public void reserve() {
        status = RoomBookingStatus.RESERVED;
    }
    public void cancel() {
        if (status == RoomBookingStatus.RESERVED)
            status = RoomBookingStatus.RESERVATION_CANCEL;
    }

    public void noshow() {
        if (status == RoomBookingStatus.RESERVED)
            status = RoomBookingStatus.NOSHOW;
    }

    public void cancelAction() {
        switch (status) {
            case CHECKED_IN: status = RoomBookingStatus.RESERVED;
                break;
            case CHECKED_OUT: status = RoomBookingStatus.CHECKED_IN;
                break;
            case RESERVATION_CANCEL: status = RoomBookingStatus.RESERVED;
                break;
            case NOSHOW: status = RoomBookingStatus.RESERVED;
                break;
            default: status = RoomBookingStatus.RESERVED;
                break;
        }
    }

    RoomBooking() {
        //Needed by hibernate
    }


    public RoomBookingStatus getRoomBookingStatus() {
        return this.status;
    }


}
