package idstay.application;

import idstay.domain.model.Crew;
import idstay.domain.model.HotelId;

import java.util.List;

/**
 * Created by min on 6/5/17.
 */
public interface HotelCrewService {

    List<Crew> getAllCrews(HotelId hotelId);
}
