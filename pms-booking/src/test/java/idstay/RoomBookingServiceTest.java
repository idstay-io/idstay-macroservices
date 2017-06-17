package idstay;


import idstay.application.RoomBookingCommand;
import idstay.application.RoomBookingService;
import idstay.application.support.RoomBookingServiceDefault;
import idstay.domain.model.*;
import idstay.infrastructure.persistance.RoomBookingRepository;
import idstay.infrastructure.persistance.RoomBookingRequestRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import static idstay.domain.model.RoomBookingStatus.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomBookingServiceTest {
    @Autowired
    RoomBookingService service;

    @Autowired
    RoomBookingRepository repository;

    /*
    YUCHI FANG
    2016-04-22 00:00:00
    2016-04-26 00:00:00
    TRIPLE
    605
    TW	NULL
    +886963042076
    ailofen624@gmail.com
    BR156
    NULL
    NULL
    280000
    280000
    Paula친구_7만/박
    no deposit
    4/25재실채크완료
    _릭	재실청소 필요없이 수건 만 교체해달라고 하셨음
    _Paula 5 bags (1 fragile)
    */

    @Test
    public void OTA_예약정보로_다시예약하기() {
        RoomBookingCommand command = new RoomBookingCommand();
        command.setHotelID(1L);
        command.setRoomCode(1L);
        command.setCheckin("2016-04-22");
        command.setCheckout("2016-04-26");
        command.setRoomTypeName("TRIPLE");
        command.setRoomNumber("605");
        command.setGuestName("YUCHI FANG");
        command.setAdults(1);
        command.setKids(0);
        command.setEmail("ailofen624@gmail.com");
        command.setNationality("TW");
        command.setPassportNumber("BR156");
        command.setPhoneNumber("+886963042076");
        command.setMemo("    Paula친구_7만/박\n" +
                "    no deposit\n" +
                "    4/25재실채크완료\n" +
                "    _릭\t재실청소 필요없이 수건 만 교체해달라고 하셨음\n" +
                "    _Paula 5 bags (1 fragile)");

        RoomBookingID bookingID = service.makeDirectReservation(command);
        assertThat(bookingID, is(notNullValue()));

        RoomBooking newBooking = repository.findOne(bookingID);
        assertThat(newBooking.getRoomBookingStatus(), is(RESERVED));
    }

    @Test
    public void foo() {
        RoomBookingID id = RoomBookingID.gen();
        Long hotelID = 1L;
        Long roomCode = 1L;
        TravelDate travelDate= TravelDate.of("2016-04-22", "2016-04-24");
        Stay stay = Stay.of(travelDate, 1, 0);
        Traveler traveler = Traveler.of("UCHI FANG");
        RoomBookingStatus status = RoomBookingStatus.RESERVED;
        RoomBooking booking = new RoomBooking(
                id,
                hotelID,
                roomCode,
                stay,
                traveler,
                status
        );

        repository.save(booking);
    }
}

