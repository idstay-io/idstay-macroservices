package idstay.application;

import idstay.application.support.OtaInvoiceParserFactory;
import idstay.domain.model.RoomBookingRequestID;

public interface RoomBookingRequestService {
    RoomBookingRequestID newOtaInvoiceBookingRequest(RoomBookingRequestCommad command, OtaInvoiceParserFactory factor);

}
