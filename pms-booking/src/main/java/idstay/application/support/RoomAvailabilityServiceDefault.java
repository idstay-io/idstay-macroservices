package idstay.application.support;


import idstay.application.RoomAvailabilityService;
import org.springframework.stereotype.Component;

@Component
public class RoomAvailabilityServiceDefault implements RoomAvailabilityService {


    @Override
    public boolean isBookable(Long roomCode, String fromDate, String toDate) {
        /*
        Optional<List<_RoomOccupancy>> roomOccupancies
                = roomOccupancyJpaRepository.findByRoomIDAndStayDate(roomCode, fromDate, toDate);
        return !roomOccupancies.get().isEmpty();
        */

        return true;
    }
}
