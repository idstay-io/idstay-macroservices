package idstay.application.support;

import idstay.application.*;
import idstay.domain.model.*;
import idstay.infrastructure.persistance.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RoomBookingServiceDefault implements RoomBookingService {
    private final RoomBookingRepository roomBookingRepository;
    private final RoomBookingRequestRepository roomBookingRequestRepository;
    private final RoomAvailabilityService roomAvailabilityService;

    private static final Logger logger = LoggerFactory.getLogger(RoomBookingServiceDefault.class);

    @Autowired
    public RoomBookingServiceDefault(final RoomBookingRepository roomBookingRepository,
                                     final RoomBookingRequestRepository roomBookingRequestRepository,
                                     final RoomAvailabilityService roomAvailabilityService) {
        this.roomBookingRepository = roomBookingRepository;
        this.roomBookingRequestRepository = roomBookingRequestRepository;
        this.roomAvailabilityService = roomAvailabilityService;
    }

    @Transactional
    public RoomBookingID bookNewReservation (final RoomBookingRequestID roomBookingRequestID,
                                             final Long roomCode) {

        final RoomBookingRequest request = roomBookingRequestRepository.findOne(roomBookingRequestID);
        if (request == null) throw new RuntimeException("No RoomBooking Request: " + roomBookingRequestID.toString());

        final RoomBookingID newRoomBookingID = RoomBookingID.gen();
        final TravelDate travelDate = request.getTravelDate();
        final Traveler traveler = request.getTraveler();
        final Stay stay = Stay.of(travelDate, 2, 0);
        final RoomBooking newBooking = new RoomBooking(newRoomBookingID, 1L, 1L, stay, traveler, RoomBookingStatus.RESERVED);

        roomBookingRepository.save(newBooking);
        logger.info("SAVED: " + newBooking.toString());

        return newBooking.id();
    }

    @Override
    public RoomBookingID makeDirectReservation(RoomBookingCommand command) throws RoomBookingDuplicatedException{
        if(!valideRoomBooking(command.getRoomCode(), command.getCheckin(), command.getCheckout()))
            throw new RoomBookingDuplicatedException();

        final RoomBookingID id = RoomBookingID.gen();
        final Long hotelID = command.getHotelID();
        final Long roomCode = command.getRoomCode();
        final TravelDate travelDate= TravelDate.of(command.getCheckin(), command.getCheckout());
        final Stay stay = Stay.of(travelDate, command.getAdults(), command.getKids());
        final Traveler traveler = Traveler.of(command.getGuestName())
                                          .email(command.getEmail())
                                          .nationality(Nationality.JP)
                                          .phoneNumber(command.getGuestContact());
        final RoomBookingStatus status = RoomBookingStatus.RESERVED;

        RoomBooking booking = new RoomBooking(
                id,
                hotelID,
                roomCode,
                stay,
                traveler,
                status
        );

        roomBookingRepository.save(booking);

        return booking.id();
    }

    private boolean valideRoomBooking(Long roomCode, String checkin, String checkout) {
        return roomAvailabilityService.isBookable(roomCode, checkin, checkout);
    }
}
