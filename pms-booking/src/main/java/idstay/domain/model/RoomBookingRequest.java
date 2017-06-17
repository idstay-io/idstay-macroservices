package idstay.domain.model;




import org.apache.commons.lang3.Validate;
import javax.persistence.*;

@Entity
@Table(name="ROOM_BOOKING_REQUEST")
public class RoomBookingRequest {
    @Id
    private RoomBookingRequestID roomBookingRequestID;

    private Long hotelID;

    @Embedded
    private TravelDate travelDate;

    @Embedded
    private Traveler traveler;

    @Lob
    private String invoice;

    private RoomBookingRequest() {
    }



    public RoomBookingRequest(final RoomBookingRequestID roomBookingRequestID, final TravelDate travelDate, final Traveler traveler) {
        Validate.notNull(roomBookingRequestID, "RoomBooking Request ID is required");
        Validate.notNull(travelDate, "Travel Date is required");
        Validate.notNull(traveler, "Traveler is required");

        this.roomBookingRequestID = roomBookingRequestID;
        this.travelDate = travelDate;
        this.traveler = traveler;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public RoomBookingRequestID id() {
        return roomBookingRequestID;
    }


    @Override
    public String toString() {
        return "RoomBookingRequest{" +
                "roomBookingRequestID=" + roomBookingRequestID +
                ", hotelID=" + hotelID +
                ", travelDate=" + travelDate +
                ", traveler=" + traveler +
                ", invoice='" + invoice + '\'' +
                '}';
    }

    public TravelDate getTravelDate() {
        return travelDate;
    }

    public Traveler getTraveler() {
        return traveler;
    }
}
