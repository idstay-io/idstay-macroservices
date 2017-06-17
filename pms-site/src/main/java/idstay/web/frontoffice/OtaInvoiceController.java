package idstay.web.frontoffice;

import idstay.facade.dto.crew.BookingDTO;
import idstay.web.frontoffice.support.OtaInvoiceCommand;
import idstay.web.frontoffice.support.RoomBookingCommand;
import idstay.web.frontoffice.support.RoomRequestCommand;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller @Slf4j
public class OtaInvoiceController {


    @GetMapping("/1/fd/invoice")
    String getInvoiceForm(OtaInvoiceCommand command) {
        log.info("getInvoiceForm is called");

        String invoice = "Guest has PRE-PAID Expedia\n" +
                "Travel arrangements provided through Expedia\n" +
                "Reservation ID: 744739184\tGuest: Kenji Tanaka\tBooked on: Oct 23 2016 02:26PST\n" +
                "81 (902) 5044193\n" +
                "tnk-kens@jcom.home.ne.jp\n" +
                "Room Type Code: Standard Double Room\n" +
                "Room Type Name:\t\tStandard Double Room - Room Only NR\n" +
                "Pricing Model: Per Day Pricing\n" +
                "Payment Instructions: Expedia collects payment from traveler: Hotel invoices Expedia.\n" +
                "Check-In\tCheck-Out\tAdults\tKids/Ages\tRoom Nights\tHotel Conf\n" +
                "Jan 02 2017\tJan 04 2017\t2\t0\t2\t\n" +
                "Special Request\n" +
                "1 double or 1 twin bed , Non-Smoking\n" +
                "Daily Rate - Package - 46,964 KRW\n" +
                "Mon, Jan 02\tTue, Jan 03\t\n" +
                "Rate Code: RoomOnlyNR\t\t\n" +
                "Discount: Airtel 40%off (min 2nights) 50da\n" +
                "Extra Person:\t0 KRW\n" +
                "Taxes:\t9,392 KRW\n" +
                "Extra Charges:\t0 KRW\n" +
                "Total Cost: \t103,320 KRW";


        command.setInvoice(invoice);
        return "fd/invoice";
    }





    @PostMapping("/{hotelId}/fd/invoice")
    String doParse(@PathVariable("hotelId") String hotelId,
                   @Valid OtaInvoiceCommand x,
                   BindingResult bindingResult,
                   Model model) {


        System.out.println("............ " + x.toString());


        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "fd/otainvoice";
        }
        //invoiceParsing()

        RoomBookingCommand req = new RoomBookingCommand();
        req.setReservationId("#257");

        req.setRoomType("CLASSIC DOUBLE");
        req.setCheckin("01/01/2017");
        req.setCheckout("12/31/2017");
        req.setAdult(2);
        req.setChildren(1);

        req.setGuestName("min");
        req.setPhone("+82-10-000-0000");

        req.setAgency("booking.com");
        req.setRegistrationNo("#54321");
        req.setMemo("agency memo");

        req.setDiscount(10);
        req.setCash(20);
        req.setCard(30);
        req.setAgencyPayment(40);
        req.setDeposit(50);


        model.addAttribute("command", req);

        //Save Req;

        return "fd/roomRequest";
    }



    @PostMapping("/{hotelId}/fd/booking")
    String getBooking(@ModelAttribute("command") RoomBookingCommand booking) {
        log.info("POST /1/fd/booking");

        return "redirect:/1/fd/bookings";
    }


    @GetMapping("/1/fd/bookings")
    String getBookings(Model model) {
        log.info("GET /1/fd/bookins");

        List<BookingDTO> bookings = new ArrayList<>();

        bookings.add(new BookingDTO(
                "Expedia",
                "#123",
                "01/01/2017",
                "/01/28/2017",
                "SEMI_DOUBLE"));

        bookings.add(new BookingDTO(
                "Agoda",
                "#1235678",
                "01/01/2017",
                "/01/28/2017",
                "SEMI_DOUBLE"));

        bookings.add(new BookingDTO(
                "Booking.com",
                "#123",
                "01/01/2017",
                "/01/28/2017",
                "SEMI_DOUBLE"));

        model.addAttribute("bookings", bookings);
        return "fd/bookingList";
    }
}
