package idstay.domain.model;

import idstay.domain.model.shared.IDGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class RoomBookingRequestID implements Serializable {
    @Column(name="BOOKING_REQUEST_ID")
    private Long id;

    public static RoomBookingRequestID gen() {
        return new RoomBookingRequestID(IDGenerator.gen());
    }
    public static RoomBookingRequestID of(Long id) {
        return new RoomBookingRequestID(id);
    }

    private RoomBookingRequestID(final Long id) {
        this.id = id;
    }

    public Long toNumber() {
        return this.id;
    }

    @Override
    public String toString() {
        return "RoomRequestID{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomBookingRequestID roomBookingRequestID = (RoomBookingRequestID) o;

        return id != null ? id.equals(roomBookingRequestID.id) : roomBookingRequestID.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    RoomBookingRequestID() {}


}
