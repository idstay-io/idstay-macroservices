package idstay.infrastructure.persistance;


import idstay.domain.model.RoomBookingRequest;
import idstay.domain.model.RoomBookingRequestID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomBookingRequestRepository extends JpaRepository<RoomBookingRequest, RoomBookingRequestID> {


}
