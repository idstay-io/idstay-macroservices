package idstay.application;

public class RoomBookingCommand {

    /*

    Hidekata Iura
    2016-04-01 00:00:00
    2016-04-04 00:00:00
    M-DOUBLE
    501
    JP
    81 (903) 9157547
    moet.et.chandon2008@gmail.com
    147600
    147600

     */

    private Long hotelID;
    private String checkin;
    private String checkout;
    private int adults;
    private int kids;
    private String roomTypeName;
    private Long roomCode;
    private String roomNumber;


    private String agency;
    private String reservationID;
    private String memo;

    private String guestName;
    private String guestContact;
    private String nationality;
    private String email;
    private String passportNumber;
    private String phoneNumber;

    private String otaInvoiceContent;

    public Long getHotelID() {
        return hotelID;
    }

    public void setHotelID(Long hotelID) {
        this.hotelID = hotelID;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
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

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public Long getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(Long roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getReservationID() {
        return reservationID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestContact() {
        return guestContact;
    }

    public void setGuestContact(String guestContact) {
        this.guestContact = guestContact;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOtaInvoiceContent() {
        return otaInvoiceContent;
    }

    public void setOtaInvoiceContent(String otaInvoiceContent) {
        this.otaInvoiceContent = otaInvoiceContent;
    }

    @Override
    public String toString() {
        return "RoomBookingCommand{" +
                "hotelID=" + hotelID +
                ", checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                ", adults=" + adults +
                ", kids=" + kids +
                ", roomTypeName='" + roomTypeName + '\'' +
                ", roomCode=" + roomCode +
                ", roomNumber='" + roomNumber + '\'' +
                ", agency='" + agency + '\'' +
                ", reservationID='" + reservationID + '\'' +
                ", memo='" + memo + '\'' +
                ", guestName='" + guestName + '\'' +
                ", guestContact='" + guestContact + '\'' +
                ", nationality='" + nationality + '\'' +
                ", email='" + email + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", otaInvoiceContent='" + otaInvoiceContent + '\'' +
                '}';
    }
}
