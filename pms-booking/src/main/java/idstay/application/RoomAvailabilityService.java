package idstay.application;

/**
 * Created by min on 4/23/17.
 */
public interface RoomAvailabilityService {
    boolean isBookable(final Long roomCode, final String fromDate, final String toDate);
}
