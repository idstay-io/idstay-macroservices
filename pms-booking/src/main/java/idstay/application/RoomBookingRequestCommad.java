package idstay.application;

/**
 * Created by min on 5/3/17.
 */
public class RoomBookingRequestCommad {
    private String roomType;
    private String arrivalDate;
    private String departureDate;
    private int rooms;
    private int adults;
    private int kids;
    private Long crewID;
    private String otaInvoiceContent;

    public String getOtaInvoiceContent() {
        return otaInvoiceContent;
    }

    public void setOtaInvoiceContent(String otaInvoiceContent) {
        this.otaInvoiceContent = otaInvoiceContent;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getKids() {
        return kids;
    }

    public void setKids(int kids) {
        this.kids = kids;
    }

    public Long getCrewID() {
        return crewID;
    }

    public void setCrewID(Long crewID) {
        this.crewID = crewID;
    }
}
