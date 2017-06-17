package idstay;


import idstay.application.*;
import idstay.application.support.RoomBookingServiceDefault;
import idstay.domain.model.*;
import idstay.infrastructure.persistance.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RoomReservationServiceMockTest {

    RoomBookingService service;

    @Mock
    RoomBookingRequestRepository roomBookingRequestRepository;

    @Mock
    RoomBookingRepository roomBookingRepository;

    RoomBookingRequest request;

    @Before
    public void setUp() {
        /*
        service = new RoomBookingServiceDefault(roomBookingRequestRepository,
                roomBookingRepository);

        RoomBookingRequestID id = RoomBookingRequestID.of("1L");

        TravelDate travelDate = TravelDate.of("2017/01/01", "2017/01/03");

        Traveler traveler = new Traveler("minsoo", "KIM");
        traveler.email("minsoo.kim@jkglobe.com")
                .nationality(Nationality.KR)
                .phoneNumber("010-4717-6225");

        request = new RoomBookingRequest(id, travelDate, traveler);
        */
    }




    @Test
    public void OTA_예약정보로_다시예약하기() {
        /*
        Optional<RoomBookingRequest> roomBookingRequest = Optional.of(request);
        when(roomBookingRequestRepository.findById(RoomBookingRequestID.of("1L"))).thenReturn(roomBookingRequest);

        Long roomCode = 1L;
        service.bookNewReservation(RoomBookingRequestID.of("1L"), roomCode);

        verify(roomBookingRepository, times(1)).save((RoomBooking)anyObject());
        */
    }

    @Test
    public void 이미_부킹된_정보로_다시_부킹() {
        fail("not implement");
    }
}

