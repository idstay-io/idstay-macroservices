package idstay.infrastructure.persistance;

import idstay.domain.model.Crew;
import idstay.domain.model.CrewCode;
import idstay.domain.model.HotelId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by min on 6/5/17.
 */
public interface CrewRepository extends JpaRepository<Crew, CrewCode> {
    List<Crew> findByHotelId(HotelId hotelId);
}
