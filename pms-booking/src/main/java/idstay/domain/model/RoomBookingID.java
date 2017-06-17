package idstay.domain.model;



import idstay.domain.model.shared.IDGenerator;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class RoomBookingID implements Serializable {
    @Column(name="BOOKING_NO")
    private Long roomBookingID;

    private RoomBookingID(final Long roomBookingID) {
        this.roomBookingID = roomBookingID;
    }
    public static RoomBookingID of(Long id) {
        return new RoomBookingID(id);
    }
    public static RoomBookingID gen() {
        return new RoomBookingID(IDGenerator.gen());
    }

    @Override
    public String toString() {
        return "RoomBookingID{" +
                "roomBookingID=" + roomBookingID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomBookingID bookingNo = (RoomBookingID) o;

        return roomBookingID != null ? roomBookingID.equals(bookingNo.roomBookingID) : bookingNo.roomBookingID == null;
    }

    @Override
    public int hashCode() {
        return roomBookingID != null ? roomBookingID.hashCode() : 0;
    }

    RoomBookingID() {}
}
