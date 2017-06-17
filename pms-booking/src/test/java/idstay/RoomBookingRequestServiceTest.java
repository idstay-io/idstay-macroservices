package idstay;

import idstay.application.RoomBookingRequestCommad;
import idstay.application.RoomBookingRequestService;
import idstay.application.support.ExpediaInvoiceParser;
import idstay.application.support.OtaInvoiceParser;
import idstay.application.support.OtaInvoiceParserFactory;

import idstay.application.support.RoomBookingRequestServiceDefault;
import idstay.domain.model.RoomBookingRequestID;
import idstay.infrastructure.persistance.RoomBookingRequestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomBookingRequestServiceTest {
    final String invoice = "\n" +
            "Guest has PRE-PAID Expedia\n" +
            "Travel arrangements provided through Expedia\n" +
            "Reservation ID: 739893076\tGuest: lucksana sangmanee\tBooked on: Oct 11 2016 20:39PST\n" +
            "66 (846) 929265\n" +
            "lucksana0208@gmail.com\n" +
            "Room Type Code: Standard Twin Room\n" +
            "Room Type Name:\t\tStandard Twin Room - Non-refundable\n" +
            "Pricing Model: Per Day Pricing\n" +
            "Payment Instructions: Expedia collects payment from traveler: Hotel invoices Expedia.\n" +
            "Check-In\tCheck-Out\tAdults\tKids/Ages\tRoom Nights\tHotel Conf\n" +
            "Dec 03 2016\tDec 07 2016\t2\t0\t4\t\n" +
            "Special Request\n" +
            "2 single beds , Non-Smoking\n" +
            "Additional Booking Info\n" +
            "Multi-room booking. Primary traveler:sangmanee, lucksana. 1 of 2 rooms.\n" +
            "Daily Rate - Package - 62,619 KRW\n" +
            "Sat, Dec 03\t\n" +
            "Rate Code: NRF0430\t\t\n" +
            "Discount: Airtel 40%off (min 2nights) 50da\n" +
            "Daily Rate - Package - 46,964 KRW\n" +
            "Sun, Dec 04\tMon, Dec 05\tTue, Dec 06\t\n" +
            "Rate Code: NRF0430\t\t\n" +
            "Discount: Airtel 40%off (min 2nights) 50da";

    @Autowired
    RoomBookingRequestService service;

    @Autowired
    RoomBookingRequestRepository repository;


    @Test
    public void expediaTest() {
        RoomBookingRequestCommad command = new RoomBookingRequestCommad();
        command.setOtaInvoiceContent(invoice);
        RoomBookingRequestID requestID = service.newOtaInvoiceBookingRequest(command, new OtaInvoiceParserFactory());

        assertThat(requestID, is(notNullValue()));
        assertThat(repository.findOne(requestID).id(), is(requestID));
        System.out.println(repository.findOne(requestID));
    }
}
