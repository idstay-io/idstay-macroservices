package idstay.application.support;

import idstay.application.RoomBookingRequestCommad;
import idstay.application.RoomBookingRequestService;
import idstay.domain.model.RoomBookingRequest;
import idstay.domain.model.RoomBookingRequestID;
import idstay.domain.model.TravelDate;
import idstay.domain.model.Traveler;
import idstay.infrastructure.persistance.RoomBookingRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomBookingRequestServiceDefault implements RoomBookingRequestService {

    private RoomBookingRequestRepository roomBookingRequestRepository;


    private static final Logger logger = LoggerFactory.getLogger(RoomBookingRequestServiceDefault.class);

    @Override
    public RoomBookingRequestID newOtaInvoiceBookingRequest(RoomBookingRequestCommad command, OtaInvoiceParserFactory factor) {
        OtaInvoiceParser parser = factor.getParser(command.getOtaInvoiceContent());
        parser.parsing();

        //roomBookingRequestRepository.fineByReservationID(parser.getReservationID());

        final RoomBookingRequestID requestID = RoomBookingRequestID.gen();

        logger.info(requestID.toString());

        final TravelDate travelDate = TravelDate.of(parser.getCheckin(), parser.getCheckout());
        final Traveler traveler = Traveler.of(parser.getGuest())
                .phoneNumber(parser.getPhone())
                .email(parser.getEmail());

        final RoomBookingRequest newBooking = new RoomBookingRequest(requestID, travelDate, traveler);
        newBooking.setInvoice(command.getOtaInvoiceContent());
        roomBookingRequestRepository.save(newBooking);

        return newBooking.id();
    }



    @Autowired
    public RoomBookingRequestServiceDefault(RoomBookingRequestRepository roomBookingRequestRepository) {
        this.roomBookingRequestRepository = roomBookingRequestRepository;
    }


}
