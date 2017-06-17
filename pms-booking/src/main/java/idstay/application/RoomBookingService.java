package idstay.application;


import idstay.domain.model.*;

public interface RoomBookingService {


    RoomBookingID makeDirectReservation(RoomBookingCommand command);
    RoomBookingID bookNewReservation(RoomBookingRequestID requestID, Long roomCode);



}
