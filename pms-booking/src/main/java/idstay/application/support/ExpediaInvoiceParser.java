package idstay.application.support;

/**
 * Created by min on 4/3/17.
 */


import org.apache.commons.lang3.Validate;

import java.util.StringTokenizer;

public class ExpediaInvoiceParser implements OtaInvoiceParser {

    private String mailContent;
    private static final String OTA_CHECKER = "Expedia";
    private static final String TOKEN = "\t\n";
    private static final String TOKEN_RESERVATION_ID = "Reservation ID: ";
    private static final String TOKEN_GUEST = "Guest: ";
    private static final String TOKEN_BOOKED_ON = "Booked on: ";
    private static final String TOKEN_ROOM_TYPE_CODE = "_Room_ Type Code: ";
    private static final String TOKEN_CHECK_IN = "Check-In";
    private static final String TOKEN_CHECK_OUT = "Check-Out";
    private static final String TOKEN_KIDS = "Kids/Ages";
    private static final String TOKEN_SPECIAL_REQUEST = "Special Request";
    private static final String TOKEN_ADULTS = "Adults";

    private String reservationID;
    private String bookedOn;
    private String phone;
    private String email;
    private String guest;
    private String checkin;
    private String checkout;
    private String roomTypeName;
    private String adults;
    private String kids;
    private String specialRequest;


    public ExpediaInvoiceParser(final String mailContent) {
        Validate.notNull(mailContent, "invoice is required");
        this.mailContent = mailContent;
    }

    @Override
    public void parsing() {
        reservationID = getParsString(TOKEN_RESERVATION_ID);
        guest = getParsString(TOKEN_GUEST);
        bookedOn = getParsString(TOKEN_BOOKED_ON);
        phone = getParsString(TOKEN_BOOKED_ON, 1);
        email = getParsString(TOKEN_BOOKED_ON, 2);
        checkin = getParsString(TOKEN_CHECK_IN, 6);
        checkout = getParsString(TOKEN_CHECK_OUT, 6);
        roomTypeName = getParsString(TOKEN_ROOM_TYPE_CODE);
        adults = getParsString(TOKEN_ADULTS, 6);
        kids = getParsString(TOKEN_KIDS, 6);
        specialRequest = getParsString(TOKEN_SPECIAL_REQUEST, 1);
    }

    @Override
    public String getReservationID() {
        return reservationID;
    }

    @Override
    public String getGuest() {
        return guest;
    }

    @Override
    public String getBookedOn() {
        return bookedOn;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getCheckin() {
        return checkin;
    }

    @Override
    public String getCheckout() {
        return checkout;
    }


    @Override
    public String getRoomTypeName() {
        return roomTypeName;
    }

    @Override
    public String getAdults() {
        return adults;
    }

    @Override
    public String getKids() {
        return kids;
    }

    @Override
    public String getSpecialRequest() {
        return specialRequest;
    }


    private String getParsString(final String token) {
        StringTokenizer tokenizer = new StringTokenizer(this.mailContent,TOKEN);

        while(tokenizer.hasMoreTokens()) {
            String str = tokenizer.nextToken();
            if(str.contains(token))
                return str.substring(token.length(), str.length());
        }
        return null;
    }

    private String getParsString(final String token, final int repeate) {
        StringTokenizer tokenizer = new StringTokenizer(this.mailContent,TOKEN);

        while(tokenizer.hasMoreTokens()) {
            if(tokenizer.nextToken().contains(token)){
                return getNextToken(tokenizer, repeate);
            }
        }
        return null;
    }

    private String getNextToken(StringTokenizer tokenizer, int repeate) {
        String nextString = "";
        for(int i=0; i<repeate; i++){
            nextString = tokenizer.nextToken();
        }
        return nextString;
    }
}
