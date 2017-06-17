package idstay.facade.dto.crew;

import lombok.Data;
import lombok.ToString;

@Data @ToString
public class BookingDTO {
    /*
    Expedia
#123
01/07/2017 – 01/09/2017
MODERN DOUBLE

     */

    private String otaName;
    private String reservationId;
    private String fromDate;
    private String toDate;
    private String roomTypeName;

    public BookingDTO(String otaName, String reservationId, String fromDate, String toDate, String roomTypeName) {
        this.otaName = otaName;
        this.reservationId = reservationId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.roomTypeName = roomTypeName;
    }

    public String getOtaName() {
        return otaName;
    }

    public void setOtaName(String otaName) {
        this.otaName = otaName;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }
}
