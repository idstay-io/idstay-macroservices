package idstay.application.support;


public interface OtaInvoiceParser {
    void parsing();

    String getReservationID();
    String getGuest();
    String getBookedOn();
    String getPhone();
    String getEmail();
    String getCheckin();
    String getCheckout();
    String getRoomTypeName();
    String getAdults();
    String getKids();
    String getSpecialRequest();
}